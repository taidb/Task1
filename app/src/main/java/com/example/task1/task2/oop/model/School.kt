package com.example.task1.task2.oop.model


// Class thường dùng để mô tả đối tượng dữ liệu (Entity, Model)
class School(val name: String, val address: String) {
    fun showInfo() {
        println("Tên trường: $name, Địa chỉ: $address")
    }

    fun isUniversity(): Boolean = name.contains("đại học", ignoreCase = true)
}
