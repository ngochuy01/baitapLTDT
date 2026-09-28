package com.example.studentinfo_2415141122108

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val student = Student(
            id = "2415141122108",
            name = "Huỳnh Ngọc Huy",
            className = "IT",
            age = 20,
            gpa = 8.5
        )

        val tvStudentId = findViewById<TextView>(R.id.tvStudentId)
        val tvStudentName = findViewById<TextView>(R.id.tvStudentName)
        val tvClassName = findViewById<TextView>(R.id.tvClassName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvGpa = findViewById<TextView>(R.id.tvGpa)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        tvStudentId.text = "Mã SV: ${student.id}"
        tvStudentName.text = "Họ tên: ${student.name.uppercase()}"
        tvClassName.text = "Lớp: ${student.className}"
        tvAge.text = "Tuổi: ${student.age}"
        tvGpa.text = "Điểm GPA: ${student.gpa}"

        val status = student.getStatus()
        tvStatus.text = "Trạng thái: $status"
        tvStatus.setTextColor(if (status == "Đạt") Color.GREEN else Color.RED)
    }
}