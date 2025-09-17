package com.example.task1.task2.oop.util


// Singleton: ứng dụng cho biến toàn cục (VD: đếm số lần truy cập, giữ config)
object MySingleton {
    var count = 0
    fun printCount() {
        println("Số lần gọi là $count")
    }
}