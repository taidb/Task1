package com.example.task1.task2.oop

import com.example.task1.task2.oop.core.EnumDemo
import com.example.task1.task2.oop.core.SealedResult
import com.example.task1.task2.oop.model.School
import com.example.task1.task2.oop.model.Staff
import com.example.task1.task2.oop.model.Student2
import com.example.task1.task2.oop.model.Teacher
import com.example.task1.task2.oop.outer.OuterClass
import com.example.task1.task2.oop.ui.CheckBox
import com.example.task1.task2.oop.ui.OnButton
import com.example.task1.task2.oop.util.MyClass
import com.example.task1.task2.oop.util.MySingleton
import com.example.task1.task2.oop.util.sum


fun main() {
    val school = School("Đại học GTVT", "Cầu giấy")
    school.showInfo()
    println("Có phải là đại học: ${school.isUniversity()}")

    val teacher = Teacher("Tiến", 30, "Nam", "Toán")
    println(teacher.info())
    teacher.showInfoName()

    println(sum(1, 2))
    println(sum(1.0, 2.0))
    println(sum(1, 2, 3))

    val staff = Staff()
    staff.work()
    staff.info()

    val checkBox = CheckBox()
    checkBox.click()
    checkBox.showMess()

    val button = OnButton()
    button.click()
    button.showMess()
    button.onClose()

    val student1 = Student2("Tài", 23, "Nam", 1)
    val student2 = Student2("Tài", 23, "Nam", 1)
    println("student1 == student2 ? ${student1 == student2}")

    MySingleton.count++
    MySingleton.printCount()

    MyClass.name = "Đặng Bá Tài"
    MyClass.printName()

    val today = EnumDemo.Mon
    println("Hôm nay là $today")

    val result: SealedResult<String> = SealedResult.Success("Thành công")
    println(result)

    println(OuterClass.NestedClass().printDescription())
    println(OuterClass().InnerClass().printDescription())
}