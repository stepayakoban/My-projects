@file:Suppress("DEPRECATION", "FunctionName")

package com.example.kitt_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity

class Time : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)
        val mTimePicker = findViewById<TimePicker>(R.id.timePicker)
        mTimePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            val myTextView = findViewById<View>(R.id.timeTextView) as TextView
            myTextView.text = "Время: $hourOfDay:$minute"
        }
        val timeButton = findViewById<Button>(R.id.timebutton)
        timeButton.setOnClickListener {
            val myTextView = findViewById<View>(R.id.timeTextView) as TextView
            myTextView.text = StringBuilder()
                    .append(mTimePicker.currentHour).append(":")
                    .append(mTimePicker.currentMinute)
        }
    }

    fun BackClick() {
        val i = Intent(this@Time, MainActivity::class.java)
        startActivity(i)
    }
}