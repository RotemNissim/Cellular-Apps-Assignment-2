package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.data.StudentRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton


class StudentListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        recyclerView = findViewById(R.id.recyclerView)
        val addButton: FloatingActionButton = findViewById(R.id.fab)

        setupRecyclerView()

        addButton.setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        // Set up the RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize adapter with sample data
        studentAdapter = StudentAdapter(
            StudentRepository.students,
            onItemClick = { position -> openStudentDetails(position) },
            onCheckboxClick = { position -> toggleStudentCheck(position) })

        recyclerView.adapter = studentAdapter
    }

    private fun openStudentDetails(position: Int) {
        val intent = Intent(this, StudentDetailsActivity::class.java)
        intent.putExtra("studentIndex", position)
        startActivity(intent)
    }

    private fun toggleStudentCheck(position: Int) {
        val student = StudentRepository.students[position]
        student.isChecked = !student.isChecked
        studentAdapter.notifyItemChanged(position)
    }

    override fun onResume() {
        super.onResume()
        val updatedStudents = StudentRepository.getAllStudents()
        studentAdapter.updateData(updatedStudents)
    }

}
