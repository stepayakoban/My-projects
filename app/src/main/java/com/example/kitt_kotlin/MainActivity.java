package com.example.kitt_kotlin;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ShowDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");
        builder.setMessage("Message");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void TimeClick(View view){
        Intent i=new Intent(MainActivity.this,Time.class);
        startActivity(i);

    };
    public void DateClick(View view){
        Intent i=new Intent(MainActivity.this,Date.class);
        startActivity(i);

    };
    public void CheckClick(View view){
        Intent i=new Intent(MainActivity.this,Check.class);
        startActivity(i);

    }
    public void ListClick(View view) {
        Intent i = new Intent(MainActivity.this, List.class);
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public void FragClick(View view) {
        Intent i = new Intent(MainActivity.this, Fragment.class);
        startActivity(i);
    }
    public void FileClick( View view){
        Intent i= new Intent( MainActivity.this, File_c.class);
        startActivity(i);
    }
    public void BdClick(View view){
        Intent i=new Intent(MainActivity.this, bd_activity.class);
        startActivity(i);
    }
}

