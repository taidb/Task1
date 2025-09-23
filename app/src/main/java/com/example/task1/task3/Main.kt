package com.example.task1.task3

import com.example.task1.task3.advanced.Box
import com.example.task1.task3.advanced.Cards
import com.example.task1.task3.advanced.DAYS
import com.example.task1.task3.advanced.NetworkResult
import com.example.task1.task3.advanced.Weather
import com.example.task1.task3.coroutines.doWorld
import com.example.task1.task3.coroutines.task1
import com.example.task1.task3.coroutines.task2
import com.example.task1.task3.higherorder.measureTime
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//Sealed Class
fun handleNetworkResult(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success -> {
            println("Success: ${result.data}")
        }

        is NetworkResult.Error -> {
            println("Error: ${result.errorMessage}")
        }

        is NetworkResult.Loading -> {
            println("Loading...")
        }
    }
}

//Enum
fun enumDay(days: DAYS) {
    when (days) {
        DAYS.SUNDAY -> println("$days is a rest day")
        DAYS.MONDAY -> println("$days is a work day")
        DAYS.TUESDAY -> println("$days is a work day")
        DAYS.WEDNESDAY -> println("$days is a work day")
        DAYS.THURSDAY -> println("$days is a work day")
        DAYS.FRIDAY -> println("$days is a work day")
        DAYS.SATURDAY -> println("$days is a rest day")
    }


}

//hàm Generics:
fun <T> printItem(a: T) {
    println("Số :$a")
}

suspend fun main() {

    //sealed class
    var success = NetworkResult.Success("Success")
    handleNetworkResult(success)
    val error = NetworkResult.Error("Error")
    handleNetworkResult(error)
    val loading = NetworkResult.Loading
    handleNetworkResult(loading)

    //enum
    var day = DAYS.SUNDAY
    enumDay(day)

    //dùng values trả về danh sách các giá trị của enum
    for (days in DAYS.values()) {
        println(days)
    }

    var summer = Weather.SUMMER
    println(summer.description())

    val color = Cards.Diamond.color
    println(color)

    //Generics
    printItem(10)
    printItem("Hello")
    printItem(10.5)

    var box = Box(6, 5)
    var box1 = Box(6.5, 5.7)
    var box2 = Box(6f, 5.5f)

    println(box.getValue())
    println(box1.getValue())
    println(box2.getValue())


    }





