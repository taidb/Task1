package com.example.task1.task3.advanced.enum

enum class TrafficLight(val seconds: Int) : Describable {
    Red(60) {
        override fun description() =
            "Stop for $seconds seconds"

    },
    Yellow(5) {
        override fun description() =
            "Slow down for $seconds seconds"

    },
    Green(30) {
        override fun description() =
            "Go for $seconds seconds"

    }


}