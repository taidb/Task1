package com.example.task1.task3.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//suspend là hàm đánh dấu có thẻ tạm dừng
suspend fun task1(): Int {
    delay(1000)
    return 20
}

suspend fun task2(): Int {
    delay(1500)
    return 30
}

fun task3(){
    println("Task 3")
}

suspend fun doWorld() = coroutineScope {
    task3()// this: CoroutineScope
    launch{
        delay(2000L)
        println("World 2")
    }
    launch{
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}

//suspend để xử lí lỗi trong coroutine
suspend fun executeWithExceptionHandling(): Int {
    try {
        val result = task1()
        return result
    } catch (e: Exception) {
        println("Error: ${e.message}")
        return -1
    }
}