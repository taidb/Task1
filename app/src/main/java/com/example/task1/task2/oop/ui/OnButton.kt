package com.example.task1.task2.oop.ui

import com.example.task1.task2.oop.core.InterfaceDemo
import com.example.task1.task2.oop.core.InterfaceDemo2

class OnButton : InterfaceDemo, InterfaceDemo2 {
    override fun click() {
        println("Bạn đã click vào Button")
    }

    override fun onClose() {
        println("Bạn đã click vào nút đóng")
    }

    override fun showMess() {
        println("Hiển thị thông tin Button")
    }
}