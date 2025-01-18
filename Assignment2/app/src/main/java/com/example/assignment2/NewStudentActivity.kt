package com.example.assignment2

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
