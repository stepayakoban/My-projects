package com.example.kitt_kotlin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class bd_activity extends AppCompatActivity {
    Button button;


    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd);
        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anime = "";

                Cursor cursor = mDb.rawQuery("SELECT * FROM animas", null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    anime += cursor.getString(1) + " | ";
                    cursor.moveToNext();
                }
                cursor.close();


            }
        });
        ArrayList<HashMap<String, Object>> animes = new ArrayList<HashMap<String, Object>>();


        HashMap<String, Object> anime;


        Cursor cursor = mDb.rawQuery("SELECT * FROM animas", null);
        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {
            anime = new HashMap<String, Object>();


            anime.put("title",  cursor.getString(1));
            anime.put("genre",  cursor.getString(2));
            anime.put("year",  cursor.getString(3));



            animes.add(anime);

            cursor.moveToNext();
        }
        cursor.close();


        String[] from = { "title", "genre","year"};
        int[] to = { R.id.textView, R.id.textView2,R.id.textView3};


        SimpleAdapter adapter = new SimpleAdapter(this, animes, R.layout.adapter_item, from, to);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

}