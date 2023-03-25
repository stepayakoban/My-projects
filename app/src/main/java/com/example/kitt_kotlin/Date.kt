package com.example.kitt_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Date : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
        val datePicker1 = findViewById<DatePicker>(R.id.datePicker1)
        datePicker1.init(2023, 1, 1) { view, year, monthOfYear, dayOfMonth ->
            val dateTextView1 = findViewById<TextView>(R.id.dateTextView)
            dateTextView1.text = "Дата: " + dayOfMonth + "/" + monthOfYear + 1 + "/" + year
        }
        val changingDateButton = findViewById<View>(R.id.date1B) as Button
        changingDateButton.setOnClickListener {
            val myTextView = findViewById<View>(R.id.dateTextView) as TextView
            myTextView.text = StringBuilder()
                    .append(datePicker1.dayOfMonth).append(".")
                    .append(datePicker1.month + 1).append(".")
                    .append(datePicker1.year)
        }
    }

    fun BackClick1() {
        val i = Intent(this@Date, MainActivity::class.java)
        startActivity(i)
    }
}