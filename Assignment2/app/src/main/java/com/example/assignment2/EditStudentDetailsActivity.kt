

package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2.data.StudentRepository

class EditStudentActivity : AppCompatActivity() {

    private var studentIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        findViewById<Button>(R.id.deleteButton).setOnClickListener {
        studentIndex = intent.getIntExtra("studentIndex", -1)
            if (studentIndex != -1) {
                // Remove the student from the repository or list
                StudentRepository.students.removeAt(studentIndex)

                // Create an intent to return to StudentListActivity
                val intent = Intent(this, StudentListActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // This ensures the activity stack is cleared
                startActivity(intent) // Start StudentListActivity with the updated list
                finish() // Finish the current activity
            }
        }

        studentIndex = intent.getIntExtra("studentIndex", -1)
        val student = StudentRepository.students[studentIndex]

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val idEditText = findViewById<EditText>(R.id.idEditText)
        nameEditText.setText(student.name)
        idEditText.setText(student.id)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            student.name = nameEditText.text.toString()
            student.id = idEditText.text.toString()
            StudentRepository.updateStudent(studentIndex, student)
            setResult(RESULT_OK) // Notify success
            finish()
        }


    }
}
