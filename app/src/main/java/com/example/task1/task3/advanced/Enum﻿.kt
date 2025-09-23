package com.example.task1.task3.advanced

//Hàm enum thông thươnờng
enum class DAYS {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}

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

//vì enum là 1 lớp nên các hằng số cos th khởi tạo bằng cách truyền các giá trị củ theer cho hàm tạo chính
enum class Cards(val color:String){
    Diamond("black"),
    Heart("red")
}