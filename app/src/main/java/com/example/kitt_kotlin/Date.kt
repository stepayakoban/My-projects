package com.example.kitt_kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.DatePicker;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Date extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        DatePicker datePicker1=findViewById(R.id.datePicker1);
        datePicker1.init(2023, 01, 01, new DatePicker.OnDateChangedListener() {

            @Override

            public void  onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


                TextView dateTextView1=findViewById(R.id.dateTextView);

                dateTextView1.setText("Дата: " + dayOfMonth + "/" + monthOfYear + 1 + "/" + year);




            }

        });
        Button changingDateButton = (Button) findViewById(R.id.date1B);
        changingDateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                TextView myTextView = (TextView) findViewById(R.id.dateTextView);
                myTextView.setText(new StringBuilder()

                        .append(datePicker1.getDayOfMonth()).append(".")
                        .append(datePicker1.getMonth() + 1).append(".")
                        .append(datePicker1.getYear()));
            }
        });
            }



    public void BackClick1(View view){
        Intent i=new Intent(Date.this,MainActivity.class);
        startActivity(i);

    };
}