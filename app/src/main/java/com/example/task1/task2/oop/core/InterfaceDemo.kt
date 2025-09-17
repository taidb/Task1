package com.example.task1.task2.oop.core

// Interface: thường ứng dụng khi muốn định nghĩa hành vi chung mà nhiều class có thể cùng triển khai (VD: Clickable, Closable)
interface InterfaceDemo {
    fun click() {}
    fun showMess() {
        println("Hiển thị thông tin mặc định")
    }
}