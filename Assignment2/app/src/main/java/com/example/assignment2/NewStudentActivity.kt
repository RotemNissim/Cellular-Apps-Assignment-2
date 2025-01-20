package com.example.assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2.data.StudentRepository
import com.example.assignment2.models.Student
import android.view.MenuItem

class NewStudentActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)
        findViewById<Button>(R.id.saveButton).setOnClickListener {
            val name = findViewById<EditText>(R.id.nameEditText).text.toString()
            val id = findViewById<EditText>(R.id.idEditText).text.toString()

            if (name.isNotBlank() && id.isNotBlank()) {
                StudentRepository.addStudent(Student(id, name, false))
                finish()
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


