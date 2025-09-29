package com.example.task1.task3.advanced.enum

//Hàm enum thông thường sử dụng companion object
enum class DAYS {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    companion object {
        fun isWeekend(day: DAYS): Boolean {
            return day == SATURDAY || day == SUNDAY
        }
        fun isWeekday(day: DAYS): Boolean {
            return !isWeekend(day)
        }
        fun getDay(index: Int): DAYS {
            return entries[index]
        }
    }
}

