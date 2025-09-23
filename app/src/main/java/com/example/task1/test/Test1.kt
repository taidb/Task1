package com.example.task1.test

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

 suspend  fun B() {
    delay(1000) // blocking 2s
    println("B done")
}

 suspend fun C() {
    delay(500) // blocking 2s
    println("C done")
}

suspend fun demosupend() {
    coroutineScope {
        println("Login success")
        launch {C() }
        launch {B()}
        A()

    }
}
//fun main(){
//    runBlocking {
//        demosupend()
//    }
//}

suspend fun halo(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}

fun main() = runBlocking<Unit> {
    halo().forEach { value -> println(value) }
}

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

