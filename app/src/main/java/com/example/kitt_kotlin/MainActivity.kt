

package com.example.kitt_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ShowDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Title")
        builder.setMessage("Message")
        builder.setPositiveButton("OK") { dialog, which -> }
        builder.setNegativeButton("Cancel") { dialog, which -> }
        val dialog = builder.create()
        dialog.show()
    }

    fun TimeClick() {
        val i = Intent(this@MainActivity, Time::class.java)
        startActivity(i)
    }

    fun DateClick() {
        val i = Intent(this@MainActivity, Date::class.java)
        startActivity(i)
    }

    fun CheckClick() {
        val i = Intent(this@MainActivity, Check::class.java)
        startActivity(i)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    fun FragClick() {
        val i = Intent(this@MainActivity, Fragment::class.java)
        startActivity(i)
    }

    fun FileClick() {
        val i = Intent(this@MainActivity, File_c::class.java)
        startActivity(i)
    }

    fun BdClick() {
        val i = Intent(this@MainActivity, bd_activity::class.java)
        startActivity(i)
    }

    fun jsoClick() {
        val i = Intent(this@MainActivity, json::class.java)
        startActivity(i)
    }
}