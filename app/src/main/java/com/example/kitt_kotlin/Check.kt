package com.example.kitt_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Check : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)
    }

    fun BackClick2(view: View?) {
        val i = Intent(this@Check, MainActivity::class.java)
        startActivity(i)
    }
}