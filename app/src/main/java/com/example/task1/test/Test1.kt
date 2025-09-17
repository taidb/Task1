package com.example.task1.test

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


fun main() {
    val cart = ShoppingCart()
    cart.addItem("Apple")
    cart.addItem("Banana")

    println(cart.items)
    // [Apple, Banana]

    cart.removeItem("Apple")
    println(cart.items)
    // [Banana]
    val station = WeatherStation()

    station.printReading()
    // No reading available
    station.latestReading = "22°C, sunny"
    station.printReading()
    // Latest reading: 22°C, sunny
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

