package com.example.task1.task2.oop.model

import com.example.task1.task2.oop.core.Worker

class Staff : Worker() {
    override fun work() {
        println("Vị trí công việc là nhân viên văn phòng")
    }
}