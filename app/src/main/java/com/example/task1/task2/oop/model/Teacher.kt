package com.example.task1.task2.oop.model


class Teacher(name: String, age: Int, gender: String, val subject: String) :
    Person(name, age, gender) {
    //ghi đè 1 phần(override)
    override fun info(): String {
        return super.info() + ", Subject: $subject"
    }

    //đi đè hoàn toàn (override)
    override fun showInfoName() {
        println("Tên là $name và dạy môn $subject")
    }
    override fun showSubject(subject: String) {
        super.showSubject(subject)
    }
}