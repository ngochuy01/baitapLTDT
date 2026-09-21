package com.example.baitapltdt

fun Student.isPassed(): Boolean {
    return this.score >= 5.0f
}

fun Student.classify(): String {
    return when {
        this.score >= 9.0f -> "Xuất sắc"
        this.score >= 8.0f -> "Giỏi"
        this.score >= 6.5f -> "Khá"
        this.score >= 5.0f -> "Trung bình"
        else -> "Yếu"
    }
}

fun Student.toDisplayString(): String {
    return "Thông tin sinh viên:\nID: $id\nHọ tên: $name\nĐiểm: $score" +
            "\nKết quả: ${if (this.isPassed()) "ĐẠT" else "KHÔNG ĐẠT"}" +
            "\nXếp loại: ${this.classify()}"
}

fun Float.toScoreText(): String {
    return String.format("%.1f điểm", this)
}