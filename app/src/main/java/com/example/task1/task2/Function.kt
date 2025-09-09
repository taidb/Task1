package com.example.task1.task2

//Extension Function
fun String.reverseString(): String {
    return this.reversed()
}

fun String.capitalizeFirst(): String {
    return this[0].uppercase() + this.substring(1)
}

fun String.lengthString(): Int {
    return this.length
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    var temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

//khai báo phần mở rộng của 1 lớp bên trong lớp khác
class Host(var hostname: String) {
    fun printHostname() {
        print(hostname)
    }
}

class Connection(var host: Host, var port: Int) {
    fun printPort() {
        print(port)
    }

    fun Host.printConnectionString() {
        printHostname()
        print(":")
        printPort()
    }

    fun connect() {
        host.printConnectionString()
    }
}

//Hàm một dòng
fun printMess() = println("Xin chao mọi ngươi")

fun isPrime(n: Int): Boolean = if (n < 2) false else (2 until n).all { n % it != 0 }

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
    fun calculateOddtotalSum(number: List<Int>): Int {
        for (num in number) {
            if (num % 2 != 0) {
                sum += num
            }
        }
        return sum
    }
    calculateOddtotalSum(data)
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
fun sum(index1: Int, index2: Int, vararg numbers: Int): Int {
    var sum = index1 + index2
    for (number in numbers) {
        sum += number
    }
    return sum
}

data class User(var name: String, var age: Int)

//Scope Function
fun scopeFunction() {

    //let: dùng khi muốn biến đổi giá trị hoặc thực hiện thao tác an toàn với null
    var user = "Tài"
    var length = user?.let {
        println("Tên là $it")
        println(it.reversed())
        it.length
    }
    println("Độ dài: $length")

    //apply : dùng để caaus hình lại đối tượng
    var updateUser = User("Tài", 23).apply {
        name = "Bình"
        age = 22
    }
    println(updateUser)

    //run : Dùng khi muốn thực hiện một khối lệnh trên đối tượng và trả về kết quả
    var result = User("Tài", 23).run {
        println("Tên : $name, Tuổi : $age")
        age + 1
    }
    println("Kết quả run :$result")

    //with :truyền đối tượng làm tham số
    var user1 = User("Tài", 23)
    val withResult = with(user1) {
        println("Tên : $name, Tuổi : $age")
        age + 2
    }
    println("Kết quả with: $withResult")

    //also : dùng để thực hiện cac tác dụng phụ mà không thay đổi đối tượng
    var user2 = User("Bình", 22)
    var user3 = user2.also {
        println("Tên: ${it.name}, Tuổi: ${it.age}")
    }
    println(user3)

}

//Hàm với generic
fun <T> printList(list: List<T>) {
    for (item in list) {
        println(item)
    }
}

//anonymous function: không có tên củ thể gọi giống giá trị 1 biến
val greet1 = fun(name: String): String {
    return "Hello, $name!"
}

//Higher-order function : là hàm có thể nhâ 1 hàm khac làm đối số
fun isOdd(x: Int) = x % 2 != 0

//lambda
val greet: () -> Unit = { println("Xin chào") }
fun operator(a: Int, b: Int, operation: (Int, Int) -> (Int)): Int {
    return operation(a, b)
}

//Default Parameter
fun greet(name: String = "Tài", age: Int = 23, hometown: String = "Nghệ An") {
    println("Xin chào $name, $age tuổi! ,$hometown ")
}

// Named Argument
fun createUser(name: String, age: Int, hometown: String) {
    println("Tên: $name, Tuổi: $age, Quê quán: $hometown")
}

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

fun main() {

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

    //Default Parameter
    greet()
    greet("Tài")
    greet("Nam", 22)

    //Named Argument
    createUser("Tài", 23, "Nghệ An")
    createUser(hometown = "Ninh Bình", name = "Bình", age = 22)

    //Hàm thông thường không trả về giá trị
    var list = listOf("Tài", "Bình", "Duy")
    printNames(list)

    // hàm thông thường có trả về giá trị
    println("Tuổi có hợp lệ không : ${isValidAge(23)}")

    //Hàm một dòng
    printMess()
    println("Số nguyên tố : ${isPrime(10)}")

    //Hamf cục bộ
    print("Hàm cục bộ: ")
    var num = listOf(2,6,7,5,9)
    calculateAndPrintResult(num)

    //Hàm thành viên
    var test = TestFunction()
    test.printFun()

    //Hàm đệ quy:
    println("Giai thừa của 5 là : ${factorial(5)}")

    //Scope Function
    scopeFunction()

    //Hàm sự dụng Varargs
    println(sum(5, 2, 3, 4, 5, 1, 6))

    //Hàm với generic
    var list2 = listOf(1, 2, 3, 4, 5)
    printList(list2)
    var list3 = listOf("Tài", "Bình", "Duy")
    printList(list3)

    //anonymous function
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

    //function Initializer Blocks
    var person = Person1("Tài", 23)
    println(person.greeting)
    try {
        var person1 = Person1("Bình", -5)
    } catch (e: IllegalArgumentException) {
        println(e.message)

    }
}