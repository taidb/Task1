package com.example.task1.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File

class ShoppingCart {
    // Backing property
    private val _items = mutableListOf<String>()

    // Public read-only view
    val items: List<String>
        get() = _items

    fun addItem(item: String) {
        _items.add(item)
    }

    fun removeItem(item: String) {
        _items.remove(item)
    }
}

suspend fun A() {
    delay(1010) // blocking 2s
    println("A done")
}

suspend fun B() {
    delay(100)
    for (i in 1..5) {
        delay(100)

        println("B ${Thread.currentThread().name}")

    }
}

suspend fun C() {
    for (i in 1..5) {
        delay(200)
        println("C ${Thread.currentThread().name}")
    }
}


fun demosupend() {
    runBlocking {
        launch(Dispatchers.Default) {
            C() }
        launch { B() }
    }
}


fun main() {
    demosupend()
}

suspend fun halo(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

//fun main() = runBlocking<Unit> {
//    halo().forEach { value -> println(value) }
//}

// cách kieemr tra khi biến đươ khai báo lateinit thì xem nó đã dược khởi tạo hay chwua: isInitialized
class WeatherStation {
    lateinit var latestReading: String

    fun printReading() {
        // Checks whether the property is initialized
        if (this::latestReading.isInitialized) {
            println("Latest reading: $latestReading")
        } else {
            println("No reading available")
        }
    }
}

//lamda mà vẫn chạy song song
fun normalFunction() {
    Thread.sleep(1000)
    println("Xong normalFunction")
}

suspend fun suspendFunction() {
    delay(1000)
    println("Xong suspendFunction")
}

//fun main() = runBlocking {
//    launch(Dispatchers.Default) { normalFunction() }
//    launch(Dispatchers.Default) { suspendFunction() }
//
//}

//Hàm ko có suspend và hàm cos nhưng E chờ F thì mới chạy:
fun E() {
    println("E start")
    Thread.sleep(2000)
    println("E done")
}

suspend fun F() {
    println("F start")
    E()
    println("F after E")
}
//fun main() = runBlocking {
////    E()
//    F()
//}

//chạy đồng thơi
//fun K() {
//    println("K start")
//    Thread.sleep(1500) // blocking 2s
//    println("K done")
//}
//
//suspend fun L() {
//    println("L start")
//    delay(1000) // giả lập công việc B
//    println("L done")
//}
//
//fun main() = runBlocking {
//    val jobK = launch(Dispatchers.Default) { K() }
//    val jobL = launch { L() }
//
//    joinAll(jobK, jobL)
//    println("Cả K và L đã xong")
//}





