package com.example.task1.task3

//Higher-order Funtion:  hàm có thể nhận 1 hàm khác làm tham số
fun <T, X> Collection<T>.fold(
    initial: X,
    combine: (acc: X, nextElement: T) -> X
): X {
    var accumulate: X = initial
    for (element: T in this) {
        accumulate = combine(accumulate, element)
    }
    return accumulate
}

fun joinByOperation(theList: List<String>, operation: (List<String>) -> String): String {
    return operation(theList)
}

fun operator(a: Int, b: Int, operation: (Int, Int) -> (Int)): Int {
    return operation(a, b)
}

// Hàm higher-order trả về 1 hàm
fun getOperation(operation: String): (Int, Int) -> (Int) {
    return when (operation) {
        "add" -> { a, b -> a + b }
        "subtract" -> { a, b -> a - b }
        "multiply" -> { a, b -> a * b }
        "divide" -> { a, b -> a / b }
        else -> throw IllegalArgumentException("Invalid operation")
    }
}

//sử dụng hàm tham chiếu:
fun add(a: Int, b: Int) = a + b

//lambda không cos tham số
val greet: () -> Unit = { println("Xin chào") }

//lambda với it
val square: (Int) -> Int = { it * it }

//lambda cơ bản
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

//sử dụng lambda như phần mở rộng lớp
fun extendString(str: String, num: Int): String {
    val another: String.(Int) -> String = { this + it }

    return str.another(num)
}

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

fun main() {
    val items = listOf(1, 2, 3, 4, 5)
    items.fold(10, { acc: Int, i: Int ->
        print("Acc=$acc,i=$i,")
        val result = acc + i
        println("result=$result")
        result
    })

    val accumulate = items.fold("Element", { acc, i -> acc + " " + i })
    println(accumulate)

    val input = listOf("a b c", "d e f", "x y z")
    val result1 = joinByOperation(input) { theList ->
        theList.joinToString(separator = " ") { str -> str.reversed() }.replace(", ", " ")
    }
    println(result1)

    val result2 = joinByOperation(input) { theList ->
        theList.reversed().joinToString(separator = " ").uppercase()
    }
    println(result2)

    val sum = operator(2, 3) { a, b -> a + b }
    val product = operator(2, 3) { a, b -> a * b }


    val sumRef = operator(2, 3, ::add)

    println("Sum: $sum, Product: $product, SumRef: $sumRef")

    // Lambda với single parameter (it)
    println("Square of 5: ${square(5)}")

    val trans100String = { input: Int ->
        var magnitude = 100 * input
        magnitude.toString()
    }
    println("Transformed: ${trans100String(5)}")


//Nếu tham số lambda không dđược sử dụng có thể đặt dấu gạch dưới thay thế cho tên cuar tham số đó
    var map = mapOf(1 to "one", 2 to "two")
    map.forEach { (_, value) -> println("$value") }

    // Extension function với lambda
    var extrendString = extendString("abc", 123)
    println(extrendString)

    // Sử dụng transform extension
    val transformedText = "hello".transforms { it.uppercase() + " WORLD" }
    println("Transformed text: $transformedText")

    // Thêm ví dụ về các hàm collection với lambda
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("Even numbers: $evenNumbers")

    val squaredNumbers = numbers.map { it * it }
    println("Squared numbers: $squaredNumbers")

    val sumAll = numbers.reduce { acc, num -> acc + num }
    println("Sum of all numbers: $sumAll")

    // Sử dụng inline function
    val executionTime = measureTime {
        var total = 0
        for (i in 1..1000) {
            total += i
        }
        println("Total: $total")
    }
    println("Execution time: ${executionTime}ms")

    // Lambda với multiple statements
    val complexOperation: (Int) -> String = { number ->
        val doubled = number * 2
        val squared = number * number
        "Number: $number, Doubled: $doubled, Squared: $squared"
    }
    println(complexOperation(5))
}

