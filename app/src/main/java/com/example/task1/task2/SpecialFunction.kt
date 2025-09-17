package com.example.task1.task2

//Default Parameter
fun greet(name: String = "Tài", age: Int = 23, hometown: String = "Nghệ An") {
    println("Xin chào $name, $age tuổi! ,$hometown ")
}

// Named Argument
fun createUser(name: String, age: Int, hometown: String) {
    println("Tên: $name, Tuổi: $age, Quê quán: $hometown")
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
