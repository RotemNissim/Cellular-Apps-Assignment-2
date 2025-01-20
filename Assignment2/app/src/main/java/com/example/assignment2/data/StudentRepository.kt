package com.example.assignment2.data

import com.example.assignment2.models.Student

object StudentRepository {
    val students = mutableListOf<Student>()

    fun getAllStudents(): List<Student> {
        return students
    }

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(index: Int, updatedStudent: Student) {
        if (index in students.indices) {
            students[index] = updatedStudent
        }
    }
    
    init {
        students.add(Student("1", "Gal Miron"))
        students.add(Student("2", "Rotem Nissim"))
    }

}

