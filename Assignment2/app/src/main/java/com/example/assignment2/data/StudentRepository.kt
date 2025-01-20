package com.example.assignment2.data

import com.example.assignment2.models.Student

object StudentRepository {
    val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(index: Int, updatedStudent: Student) {
        students[index] = updatedStudent
    }

    fun deleteStudent(index: Int) {
        students.removeAt(index)
    }

    init {
        students.add(Student("1", "John Doe"))
        students.add(Student("2", "Jane Smith"))
    }

}

