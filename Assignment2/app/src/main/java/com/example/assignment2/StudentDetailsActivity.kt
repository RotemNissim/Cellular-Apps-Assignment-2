package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2.data.StudentRepository

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
