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
            var auto = "auto"
            val cursor = mDb?.rawQuery("SELECT * FROM automobil", null)
            cursor?.moveToFirst()
            while (!cursor?.isAfterLast!!) {
                auto += cursor.getString(1) + " | "
                cursor.moveToNext()
            }
            cursor.close()
        }
        val autos = ArrayList<HashMap<String, Any?>>()
        var auto: HashMap<String, Any?>
        val cursor = mDb?.rawQuery("SELECT * FROM automobil", null)
        cursor!!.moveToFirst()
        while (!cursor.isAfterLast) {
            auto = HashMap()
            auto["name"] = cursor.getString(1)
            auto["color"] = cursor.getString(2)
            auto["year"] = cursor.getString(3)
            auto["price"] = cursor.getString(4)
            autos.add(auto)
            cursor.moveToNext()
        }
        cursor.close()
        val from = arrayOf("name", "color", "year", "price")
        val to = intArrayOf(R.id.textView, R.id.textView2, R.id.textView3, R.id.textView4)
        val adapter = SimpleAdapter(this, autos, R.layout.adapter_item, from, to)
        val listView = findViewById<View>(R.id.listView) as ListView
        listView.adapter = adapter
    }
}