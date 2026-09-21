package com.example.baitapltdt

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Model minh họa
data class Student(var id: Int, var name: String, var score: Float)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvInfo = findViewById<TextView>(R.id.tvInfo)

        // 1. apply: Khởi tạo và cấu hình thuộc tính của đối tượng (Trả về đối tượng đó)
        val student = Student(1, "Nguyen Van A", 7.5f).apply {
            score = 8.5f // Cập nhật lại điểm
            Log.d("ScopeDemo", "Đã khởi tạo student bằng apply: $name")
        }

        // 2. let: Kiểm tra null và thực hiện công việc với biến không null (it)
        val studentName: String? = student.name
        studentName?.let { name ->
            Log.d("ScopeDemo", "Tên sinh viên không null (let): $name")
        }

        // 3. also: Thực hiện một hành động phụ (như ghi log) mà không thay đổi đối tượng (it)
        student.also {
            Log.d("ScopeDemo", "Ghi log bằng also: ID=${it.id}, Name=${it.name}, Score=${it.score}")
        }

        // 4. with: Nhóm các thao tác trên cùng 1 đối tượng mà không cần lặp lại tên đối tượng (this)
        val formattedResult = with(student) {
            "Thông tin sinh viên:\nID: $id\nHọ tên: $name\nĐiểm: $score"
        }

        // 5. run: Kết hợp cấu hình đối tượng và trả về kết quả tính toán cuối cùng
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