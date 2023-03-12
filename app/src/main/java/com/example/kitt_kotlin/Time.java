package com.example.kitt_kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class Time extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        TimePicker   mTimePicker = findViewById(R.id.timePicker);



        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

        @Override

        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            TextView myTextView = (TextView) findViewById(R.id.timeTextView);


            myTextView.setText("Время: " + hourOfDay + ":" + minute);

        }

    });
        Button timeButton = findViewById(R.id.timebutton);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView myTextView = (TextView) findViewById(R.id.timeTextView);
                myTextView.setText(new StringBuilder()
                        .append(mTimePicker.getCurrentHour()).append(":")
                        .append(mTimePicker.getCurrentMinute()));
            }
        });
}

    public void BackClick(View view){
        Intent i=new Intent(Time.this,MainActivity.class);
        startActivity(i);

    };


}
