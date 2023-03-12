package com.example.kitt_kotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<String> items = new ArrayList<>();
        items.add("Муся");
        items.add("Тьма");
        items.add("Алиса");
        items.add("Маруся");
        items.add("Тима");
        items.add("Маша");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, items);
        ListView listView = (ListView) findViewById(R.id.List);
        listView.setAdapter(adapter);
        listView.setBackgroundColor(0x80000000);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        EditText editText = findViewById(R.id.text_for_kitty);

        Button buttonAdd = findViewById(R.id.Adder);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                adapter.add(text);
                adapter.notifyDataSetChanged();
            }
        });
Button buttonRemove=findViewById(R.id.Remover);
ArrayList<String> selectedItems = new ArrayList<>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                selectedItems.add(selectedItem);
            }
        });
buttonRemove.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Iterator<String> iterator = selectedItems.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            adapter.remove(item);
        }
                adapter.notifyDataSetChanged();
        selectedItems.clear();

    }
});


    }



    public void BackClickL(View view){
        Intent i=new Intent(List.this,MainActivity.class);
        startActivity(i);

    };



}