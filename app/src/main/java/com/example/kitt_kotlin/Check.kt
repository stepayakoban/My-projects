package com.example.kitt_kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
    }
    public void BackClick2(View view){
        Intent i=new Intent(Check.this,MainActivity.class);
        startActivity(i);

    };
}