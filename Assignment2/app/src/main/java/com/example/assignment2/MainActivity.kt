package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.ui.theme.Assignment2Theme

class StudentListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        recyclerView = findViewById(R.id.recyclerView)

        setupRecyclerView()
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            startActivity(Intent(this, NewStudentActivity::class.java))
        }
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        studentAdapter = StudentAdapter(
            StudentRepository.students,
            onItemClick = { openStudentDetails(it) },
            onCheckboxClick = { toggleStudentCheck(it) }
        )
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
}
