package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val index = intent.getIntExtra("studentIndex", -1)
        val student = StudentRepository.students[index]

        findViewById<TextView>(R.id.nameTextView).text = student.name
        findViewById<TextView>(R.id.idTextView).text = student.id

        findViewById<Button>(R.id.editButton).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("studentIndex", index)
            startActivity(intent)
        }
    }
}
