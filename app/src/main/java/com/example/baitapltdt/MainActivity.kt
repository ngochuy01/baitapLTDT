package com.example.baitapltdt

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Student(var id: Int, var name: String, var score: Float)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvInfo = findViewById<TextView>(R.id.tvInfo)

        val student = Student(1, "Huynh Ngoc Huy", 7.5f).apply {
            score = 8.5f
            Log.d("ScopeDemo", "Đã khởi tạo student bằng apply: $name")
        }

        val studentName: String? = student.name
        studentName?.let { name ->
            Log.d("ScopeDemo", "Tên sinh viên không null (let): $name")
        }

        student.also {
            Log.d("ScopeDemo", "Ghi log bằng also: ID=${it.id}, Name=${it.name}, Score=${it.score}")
        }

        val formattedResult = with(student) {
            "Thông tin sinh viên:\nID: $id\nHọ tên: $name\nĐiểm: $score"
        }

        val isPassed = student.run {
            score >= 5.0f
        }

        // Cập nhật lên giao diện
        tvInfo.apply {
            text = "$formattedResult\nKết quả: ${if (isPassed) "ĐẠT" else "KHÔNG ĐẠT"}"
            textSize = 18f
        }
    }
}