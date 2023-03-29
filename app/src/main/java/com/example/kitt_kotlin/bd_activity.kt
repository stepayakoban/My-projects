

package com.example.kitt_kotlin

import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class bd_activity : AppCompatActivity() {
    var button: Button? = null
    private var mDBHelper: DatabaseHelper? = null
    private var mDb: SQLiteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bd)
        mDBHelper = DatabaseHelper(this)
        try {
            mDBHelper!!.updateDataBase()
        } catch (mIOException: IOException) {
            throw Error("UnableToUpdateDatabase")
        }
        mDb = try {
            mDBHelper!!.writableDatabase
        } catch (mSQLException: SQLException) {
            throw mSQLException
        }
        button = findViewById<View>(R.id.button) as Button
        button!!.setOnClickListener {
            var anime = ""
            val cursor = mDb?.rawQuery("SELECT * FROM animas", null)
            cursor?.moveToFirst()
            while (!cursor?.isAfterLast!!) {
                anime += cursor.getString(1) + " | "
                cursor.moveToNext()
            }
            cursor.close()
        }
        val animes = ArrayList<HashMap<String, Any?>>()
        var anime: HashMap<String, Any?>
        val cursor = mDb?.rawQuery("SELECT * FROM animas", null)
        cursor!!.moveToFirst()
        while (!cursor.isAfterLast) {
            anime = HashMap()
            anime["title"] = cursor.getString(1)
            anime["genre"] = cursor.getString(2)
            anime["year"] = cursor.getString(3)

            animes.add(anime)
            cursor.moveToNext()
        }
        cursor.close()


        val from = arrayOf( "title", "genre","year")
        val to = intArrayOf( R.id.name_text_view, R.id.genre_text_view,R.id.year_text_view)


        val adapter = SimpleAdapter(this, animes, R.layout.adapter_item, from, to)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

    }
}