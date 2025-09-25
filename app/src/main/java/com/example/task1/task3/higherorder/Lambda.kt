package com.example.task1.task3.higherorder

import com.example.task1.task3.advanced.reflection.Person

//lambda không cos tham số
val greet: () -> Unit = { println("Xin chào") }

//lambda với it
val square: (Int) -> Int = { it * it }

//lambda cơ bản
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

//lambda nhận tham số nhưng trả về Unit
val printNumber: (Int) -> Unit = { _ ->
    println("Hello World")
}

val printNumber1: (Int) -> Unit = { num ->
    println("Number :${num}")
}

//sử dụng lambda như phần mở rộng lớp
fun extendString(str: String, num: Int): String {
    val another: String.(Int) -> String = { this + it }
    return str.another(num)
}

//Trong UI có thể sự dụng để gọi sự kiện ví dụ
//button.setOnClickListener {
//}

//Extension function
fun String.transforms(transform: (String) -> String): String {
    return transform(this)
}

//inline Function : khi muốn tối ưu hóa hieeur năng cho các hàm được gọi nhiều lần và có kích nhỏ tránh chi phí gọi hàm
inline fun measureTime(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}


//StringBuilder là class dùng để tạo và xử lý chuỗi (string) có thể thay đổi được (mutable).
val buildMess: StringBuilder.() -> Unit = {
    append("Hello")
    append(" ")
    append("World!")
}

//lambda với nullable : có thể trả về null
val safeLength: (String?) -> Int? = { str -> str?.length ?: 0 }

//lambda với scope functions
val person = Person("Nguyễn Văn A", "Hà Nội").apply {
    name = "Đặng Bá Tài"
    address = "Nghệ An"
}

fun main() {
    greet()
    // Lambda với single parameter (it)
    println("Bình phương 1 số: ${square(5)}")

    println("Tổng :${sum(1, 2)}")

    printNumber(10)

    printNumber1(10)

    // Extension function với lambda
    val extrendString = extendString("abc", 123)
    println(extrendString)

    val name = "Tai".transforms { it.uppercase() + "Đặng" }
    println(name)

    // Sử dụng inline function
    val executionTime = measureTime {
        var total = 0
        for (i in 1..1000) {
            total += i
        }
        println("Total: $total")
    }
    println("Execution time: ${executionTime}ms")

    println(buildMess)

    println(safeLength(null))

    println("${person.name} - ${person.address}")

    // hàm collection với lambda
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("Even numbers: $evenNumbers")

    val squaredNumbers = numbers.map { it * it }
    println("Squared numbers: $squaredNumbers")

    val sumAll = numbers.reduce { acc, num -> acc + num }
    println("Sum of all numbers: $sumAll")


    // Lambda với multiple statements
    val complexOperation: (Int) -> String = { number ->
        val doubled = number * 2
        val squared = number * number
        "Number: $number, Doubled: $doubled, Squared: $squared"
    }
    println(complexOperation(5))

    //Nếu tham số lambda không dđược sử dụng có thể đặt dấu gạch dưới thay thế cho tên cuar tham số đó
    val map = mapOf(1 to "one", 2 to "two")
    map.forEach { (_, value) -> println(value) }

    val trans100String = { input: Int ->
        val magnitude = 100 * input
        magnitude.toString()
    }
    println("Transformed: ${trans100String(5)}")
}


