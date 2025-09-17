package com.example.task1.task3

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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


    //suspend function
    runBlocking {
        var time = measureTime {
            val result1 = task1()
            val result2 = task2()
            println("Result 1: $result1")
            println("Result 2: $result2")
            println("Giá trị tổng: ${result1 + result2}")

        }
        println("Thời gian thực thi: $time ms")

        doWorld()
        println("Done")

        //Muốn cả 2 thực hiện dồng thời sự dụng : async
        val time2 = measureTimeMillis {
            val one = async { task1() }
            val two = async { task2() }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time2 ms")

        //Lazily started async : chỉ khởi động coroutine khi kết quả của nó được yêu cầu bởi await
        val time3 = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { task1() }
            val two = async(start = CoroutineStart.LAZY) { task2() }
            one.start()
            two.start()
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time3 ms")

    }
}




