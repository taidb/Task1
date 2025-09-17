package com.example.task1.task2

import com.example.task1.task2.oop.util.Connection
import com.example.task1.task2.oop.util.Host
import java.math.BigDecimal

//hàm thông thường có trả về giá trị
fun isValidAge(age: Int): Boolean {
    if (age in 0..100) {
        return true
    } else {
        return false
    }
}

// hàm ko trả về giá trị
fun printNames(names: List<String>) {
    for (name in names) {
        println("Xin chào $name")
    }
}

//hàm cục bộ : chỉ được gọi hoặc truy cập bên trong hàm chứa nó
fun calculateAndPrintResult(data: List<Int>) {
    var sum = 0
    fun calculateOddTotalSum(number: List<Int>): Int {
        for (num in number) {
            if (num % 2 != 0) {
                sum += num
            }
        }
        return sum
    }
    calculateOddTotalSum(data)
    println("Tổng các số lẻ là: $sum")
}

//Hàm thành viên : là hàm được định nghĩa bên trong 1 đối tượng hoặc lơps
class TestFunction {
    fun printFun() {
        println("Hàm thành viên")
    }
}

//Ham đệ quy:
fun factorial(n: Int): Long {
    if (n == 0 || n == 1) {
        return 1
    } else {
        return n * factorial(n - 1)
    }
}

//Hàm sự dụng Varargs : hàm có thể nhận được nhiều tham số , bản chất của varargs chính là arrays
fun sum(a: Int, b: Int, vararg numbers: Int): Int {
    var sum = a + b
    for (number in numbers) {
        sum += number
    }
    return sum
}

data class User(var name: String, var age: Int)

//Đánh dấu mã sau khi hoàn thành :TODO
fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")

//function Initializer Blocks
class Person1(name: String, val age: Int) {
    var greeting: String = ""

    init {
        greeting = "Xin chào bạn $name ,$age tuổi"
        println("Name is $name")
    }

    init {
        if (age < 0) throw IllegalArgumentException("Giá trị không hợp lệ")
    }
}

//Hàm với generic
fun <T> printList(list: List<T>) {
    for (item in list) {
        println(item)
    }
}

//Hàm một dòng
fun printMess() = println("Xin chao mọi ngươi")

fun isPrime(n: Int): Boolean = if (n < 2) false else (2 until n).all { n % it != 0 }

fun theAnswer() = 42

fun main() {
    //Hàm thông thường
    var list = listOf("Tài", "Bình", "Duy")
    printNames(list)
    println("Tuổi có hợp lệ không : ${isValidAge(23)}")   // hàm thông thường có trả về giá trị

    //Hàm cục bộ
    print("Hàm cục bộ: ")
    var num = listOf(2, 6, 7, 5, 9)
    calculateAndPrintResult(num)

    //Hàm thành viên
    var test = TestFunction()
    test.printFun()

    //Hàm đệ quy:
    println("Giai thừa của 5 là : ${factorial(5)}")

    //Hàm sự dụng Varargs
    println(sum(5, 2, 3, 4, 5, 1, 6))

    //Hàm với generic
    var list2 = listOf(1, 2, 3, 4, 5)
    var list3 = listOf("Tài", "Bình", "Duy")
    printList(list2)
    printList(list3)

    //function Initializer Blocks
    var person = Person1("Tài", 23)
    println(person.greeting)
    try {
        var person1 = Person1("Bình", -5)
    } catch (e: IllegalArgumentException) {
        println(e.message)

    }

    //Hàm đặc biệt:
    // anonymous function
    println(greet1("Tài"))

    //Higher-order function
    val number = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(number.filter(::isOdd))

    //lambda
    var sum = operator(5, 6) { x, y -> x + y }
    println("Tổng là : $sum")
    var sub = operator(5, 6) { x, y -> x - y }
    println("Hiệu là : $sub")
    var mul = operator(5, 6) { x, y -> x * y }
    println("Tích là : $mul")
    var div = operator(5, 6) { x, y -> x / y }
    println("Thương là : $div")

    //Hàm một dòng
    printMess()
    println("Số nguyên tố : ${isPrime(10)}")

    //Kiểm tra lỗi & Validation
    println(getIndices(5))
    //   println(getIndices(-1)) ->lỗi
    val user1 = com.example.task1.task1.User("Alice", "admin")
    processUserRole(user1)
    println(checkInt(5))

    // DEFAULT PARAMETER & NAMED ARGUMENT
    greet()
    greet("Tài")
    greet("Nam", 22)
    createUser("Tài", 23, "Nghệ An")
    createUser(hometown = "Ninh Bình", name = "Bình", age = 22)

    //Extension Function
    var name: String = "dặng Bá Tài"
    println("In chuỗi đảo ngược : ${name.reverseString()}")
    println("Số phần tử: ${name.lengthString()}")
    println("In hoa chữ cái đầu tiên : ${name.capitalizeFirst()}")
    var list1 = mutableListOf(3, 6)
    list1.swap(0, 1)
    println(list1)

    var connection = Connection(Host("google.com"), 80)
    connection.connect()

    //Scope Function
    demoLet()
    demoApply()
    demoRun()
    demoWith()
    demoAlso()
}