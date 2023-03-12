package com.example.kitt_kotlin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class File_c extends AppCompatActivity {

    FileOutputStream fos = null;
    private final static String FILE_NAME = "content.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
    }

    public void saveText(View view) {


        try {
            EditText textBox = findViewById(R.id.edittext);
            String text = textBox.getText().toString();

            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
            readFile("content.txt");
        } catch (IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException ex) {

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void del_file(View view) {
        File file = new File(getFilesDir(), "content.txt");
        if (file.exists()) {
            if (file.delete()) {
                TextView textView=findViewById(R.id.text1);
                TextView textView1=findViewById(R.id.text3);
                textView1.setText("");
                textView.setText("");
                Toast.makeText(this, "Файл удален", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ошибка при удалении файла", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Файл не существует", Toast.LENGTH_SHORT).show();
        }
    }
    public void Change(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Введите текст");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = input.getText().toString();
                try {
                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    fos.write(text.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                TextView textView = findViewById(R.id.text3);
                try {
                    String fileName=FILE_NAME;
                    FileInputStream fileInputStream = openFileInput(fileName);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    String fileContent = stringBuilder.toString();

textView.setText(fileContent);


                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }

    public void readFile(String fileName) {
        try {
            FileInputStream fileInputStream = openFileInput(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            String fileContent = stringBuilder.toString();


            TextView textView = findViewById(R.id.text1);
            textView.setText(fileContent);

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }




