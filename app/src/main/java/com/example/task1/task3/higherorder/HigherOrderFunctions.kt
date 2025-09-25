package com.example.task1.task3.higherorder

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


//Higher-order Funtion:  hàm có thể nhận 1 hàm khác làm tham số hoặc trả về 1 hàm
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

//ở đây cũng có sự dụng lambda cho hàm bậc cao
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

//Nhiều thông số lambda
fun twoOperation(
    a: Int,
    b: Int,
    op1: (Int, Int) -> Int,
    op2: (Int, Int) -> Int
): Pair<Int, Int> {
    return Pair(op1(a, b), op2(a, b))
}

// nhận hàm suspend làm tham số
suspend fun runTask(task: suspend () -> Unit) {
    println("Start task...")
    task()
    println("End task")
}

suspend fun task() {
    println("Task is running")
    delay(100)
    println("Task is done")
}

//sử dụng hàm tham chiếu:
fun add(a: Int, b: Int) = a + b
fun isEven(a: Int) = a % 2 == 0

fun main() {
    val items = listOf(1, 2, 3, 4, 5)
    items.fold(10) { acc: Int, i: Int ->
        print("Acc=$acc,i=$i,")
        val result = acc + i
        println("result=$result")
        result
    }

    val accumulate = items.fold("Element") { acc, i -> "$acc  $i" }
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
    val subtraction = operator(2, 3) { a, b -> a - b }
    val multiplication = operator(2, 3) { a, b -> a * b }
    val division = operator(2, 3) { a, b -> a / b }
    println("Sum: $sum, Multiplication: $multiplication,Subtraction: $subtraction,Division: $division")

    val getOperation = getOperation("add")(2, 3)
    println(getOperation)

    val sumRef = operator(2, 3, ::add)
    println("SumRef: $sumRef")
    println("Số a là số chẵn không : ${isEven(2)}")

    val (first, sencond) = twoOperation(5, 6, { a, b -> a + b }, { a, b -> a - b })
    println("$first,$sencond")

    runBlocking {
        runTask { task() }
        launch { }
    }
}

