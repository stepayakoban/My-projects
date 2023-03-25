@file:Suppress("ClassName", "SameParameterValue")

package com.example.kitt_kotlin


import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.io.*

@Suppress("FunctionName", "UNUSED_ANONYMOUS_PARAMETER")
class File_c : AppCompatActivity() {
    private var fos: FileOutputStream? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file)
    }

    fun saveText() {
        try {
            val textBox = findViewById<EditText>(R.id.edittext)
            val text = textBox.text.toString()
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE)
            fos?.write(text.toByteArray())
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show()
            readFile("content.txt")
        } catch (ex: IOException) {
            Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
        } finally {
            try {
                if (fos != null) fos!!.close()
            } catch (ex: IOException) {
                Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun del_file() {
        val file = File(filesDir, "content.txt")
        if (file.exists()) {
            if (file.delete()) {
                val textView = findViewById<TextView>(R.id.text1)
                val textView1 = findViewById<TextView>(R.id.text3)
                textView1.text = ""
                textView.text = ""
                Toast.makeText(this, "Файл удален", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ошибка при удалении файла", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Файл не существует", Toast.LENGTH_SHORT).show()
        }
    }

    fun Change() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Введите текст")
        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)
        builder.setPositiveButton("OK") { dialog, which ->
            val text = input.text.toString()
            try {
                fos = openFileOutput(FILE_NAME, MODE_PRIVATE)
            } catch (e: FileNotFoundException) {
                throw RuntimeException(e)
            }
            try {
                fos?.write(text.toByteArray())
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
            val textView = findViewById<TextView>(R.id.text3)
            try {
                val fileName = FILE_NAME
                val fileInputStream = openFileInput(fileName)
                val inputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder = StringBuilder()
                var line: String?
                while ((bufferedReader.readLine().also { line = it }) != null) {
                    stringBuilder.append(line).append("\n")
                }
                val fileContent = stringBuilder.toString()
                textView.text = fileContent
                bufferedReader.close()
                inputStreamReader.close()
                fileInputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        builder.setNegativeButton("Отмена") { dialog, which -> dialog.cancel() }
        builder.show()
    }

    private fun readFile(fileName: String?) {
        try {
            val fileInputStream = openFileInput(fileName)
            val inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuilder = StringBuilder()
            var line: String?
            while ((bufferedReader.readLine().also { line = it }) != null) {
                stringBuilder.append(line).append("\n")
            }
            val fileContent = stringBuilder.toString()
            val textView = findViewById<TextView>(R.id.text1)
            textView.text = fileContent
            bufferedReader.close()
            inputStreamReader.close()
            fileInputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val FILE_NAME = "content.txt"
    }
}