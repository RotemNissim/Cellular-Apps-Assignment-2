package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.models.Student

class StudentAdapter(
    private var students: List<Student>,
    private val onItemClick: (Int) -> Unit,
    private val onCheckboxClick: (Int) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val studentImage: ImageView = view.findViewById(R.id.studentImage)
        val studentName: TextView = view.findViewById(R.id.studentName)
        val studentId: TextView = view.findViewById(R.id.studentId)
        val studentCheckBox: CheckBox = view.findViewById(R.id.studentCheckBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.studentName.text = student.name
        holder.studentId.text = student.id
        holder.studentCheckBox.isChecked = student.isChecked

        holder.itemView.setOnClickListener { onItemClick(position) }
        holder.studentCheckBox.setOnCheckedChangeListener { _, _ -> onCheckboxClick(position) }
    }

    fun updateData(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged()
    }

    override fun getItemCount() = students.size
}
