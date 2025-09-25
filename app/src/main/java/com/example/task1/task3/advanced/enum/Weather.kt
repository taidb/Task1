package com.example.task1.task3.advanced.enum

//Hàm enum khai báo các lớp ẩn danh của riêng
enum class Weather {
    SUMMER {
        override fun description() = "Hot days of a year"
    },
    WINTER {
        override fun description() = "Cold days of a year"
    };

    abstract fun description(): String
}
