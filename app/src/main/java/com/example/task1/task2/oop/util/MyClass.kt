package com.example.task1.task2.oop.util

// Companion object: ứng dụng khi muốn có "static function/property" trong class
class MyClass {
    companion object {
        var name = "Tài"
        fun printName() {
            println("Tên là $name")
        }
    }
}