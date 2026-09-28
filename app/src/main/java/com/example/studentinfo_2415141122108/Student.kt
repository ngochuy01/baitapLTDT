package com.example.studentinfo_2415141122108

data class Student(
    val id: String,
    val name: String,
    val className: String,
    val age: Int,
    val gpa: Double
)

// Extension Function: Kiểm tra Đạt / Chưa đạt (Dành cho MSSV số chẵn)
fun Student.getStatus(): String {
    return if (this.gpa >= 5.0) "Đạt" else "Chưa đạt"
}