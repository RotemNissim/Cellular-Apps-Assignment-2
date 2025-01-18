package com.example.assignment2

class EditStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val index = intent.getIntExtra("studentIndex", -1)
        val student = StudentRepository.students[index]

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val idEditText = findViewById<EditText>(R.id.idEditText)
        nameEditText.setText(student.name)
        idEditText.setText(student.id)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            student.name = nameEditText.text.toString()
            student.id = idEditText.text.toString()
            StudentRepository.updateStudent(index, student)
            finish()
        }

        findViewById<Button>(R.id.deleteButton).setOnClickListener {
            StudentRepository.deleteStudent(index)
            finish()
        }
    }
}
