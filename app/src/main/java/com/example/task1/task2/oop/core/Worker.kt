package com.example.task1.task2.oop.core

// Abstract class: dùng để tạo khung sườn cho lớp con (VD: mỗi loại nhân viên phải có work khác nhau)
abstract class  Worker {
    abstract fun work()
    fun info() {
        println("Thông tin nhân viên")
    }
}
