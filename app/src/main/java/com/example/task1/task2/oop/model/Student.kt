package com.example.task1.task2.oop.model

//Constructor (Primary & Secondary)
class Student(var name: String, var age: Int, var gender: String, val id: Int) {
    init {
        println("Họ tên: $name, Tuổi: $age, Giới tính: $gender, Mã sinh viên: $id")
    }

    var school: String = ""

    constructor(name: String, age: Int, gender: String, id: Int, school: String) : this(
        name, age, gender, id
    ) {
        this.school = school
    }

}

