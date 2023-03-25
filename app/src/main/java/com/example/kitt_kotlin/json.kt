@file:Suppress("ClassName", "FunctionName")

package com.example.kitt_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset

class json : AppCompatActivity() {
    @Suppress("PropertyName")
    var ListItemclass: List<ListItem>? = null
    private var listView: ListView? = null
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)
        listView = findViewById<View>(R.id.listView) as ListView
        ListItemclass = ArrayList()
        loadItemsFromJson()
    }

    private fun loadItemsFromJson(): List<ListItem> {
        var jsonString = ""
        try {
            val inputStream = assets.open("sample4.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            jsonString = buffer.toString(Charset.forName("UTF-8"))

        } catch (e: IOException) {
            e.printStackTrace()
        }
        val objects: MutableList<ListItem> = ArrayList()
        try {
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val `object` = ListItem(jsonObject.getString("firstName"), jsonObject.getString("lastName"), jsonObject.getString("gender"), jsonObject.getString("age"), jsonObject.getString("number"))
                objects.add(`object`)
            }
            val adapter = ListAdapter(this, objects)
            adapter.notifyDataSetChanged()
            listView!!.adapter = adapter
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return objects
    }

    fun BackC1lick() {
        val i = Intent(this@json, MainActivity::class.java)
        startActivity(i)
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down)
    }
}