

package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2.data.StudentRepository

class StudentDetailsActivity : AppCompatActivity() {

    private var studentIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentIndex = intent.getIntExtra("studentIndex", -1)
        updateStudentDetails()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<Button>(R.id.editButton).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("studentIndex", studentIndex)
            startActivityForResult(intent, EDIT_STUDENT_REQUEST_CODE)
        }
    }

    private fun updateStudentDetails() {
        val student = StudentRepository.students[studentIndex]
        findViewById<TextView>(R.id.nameTextView).text = student.name
        findViewById<TextView>(R.id.idTextView).text = student.id
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_STUDENT_REQUEST_CODE && resultCode == RESULT_OK) {
            updateStudentDetails()
        }
    }

    companion object {
        private const val EDIT_STUDENT_REQUEST_CODE = 1
    }
}

