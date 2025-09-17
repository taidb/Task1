package com.example.task1.task2.oop.model

// Lớp cha: ứng dụng khi nhiều lớp có chung đặc điểm (Person -> Teacher, Student, Staff...)
open class Person(val name: String, val age: Int, val gender: String) {
    open fun info(): String {
        return "Name: $name, Age: $age, Gender: $gender"
    }

    open fun showInfoName() {
        println("Tên là $name")
    }

    open fun showSubject(subject: String) =
        println("Môn học là $subject")

}