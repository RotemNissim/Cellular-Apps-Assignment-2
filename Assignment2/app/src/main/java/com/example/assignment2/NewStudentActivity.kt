package com.example.assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2.models.Student

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val name = findViewById<EditText>(R.id.nameEditText).text.toString()
            val id = findViewById<EditText>(R.id.idEditText).text.toString()

            if (name.isNotBlank() && id.isNotBlank()) {
                StudentRepository.addStudent(Student(id, name))
                finish()
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
