package com.example.task1.task2


//Scope Function
data class User1(var name: String, var age: Int)

// let: Dùng để biến đổi giá trị hoặc xử lý an toàn với null
fun demoLet() {
    var user: String? = "Tài"
    var length = user?.let {
        println("Tên là $it")
        println("Tên đảo ngược: ${it.reversed()}")
        it.length  // trả về độ dài của chuỗi
    }
    println("Độ dài: $length")
}

// apply: Dùng để cấu hình đối tượng (thường dùng khi khởi tạo)
fun demoApply() {
    var updateUser = User1("Tài", 23).apply {
        name = "Bình"
        age = 22
    }
    println("User sau khi apply: $updateUser")
}

// run: Dùng khi muốn thực hiện một khối lệnh và trả về kết quả
fun demoRun() {
    var result = User1("Tài", 23).run {
        println("Tên : $name, Tuổi : $age")
        age + 1  // giá trị trả về của run
    }
    println("Kết quả run: $result")
}

// with: Dùng khi muốn gọi nhiều hàm trên cùng một đối tượng (truyền đối tượng làm tham số)
fun demoWith() {
    var user = User1("Tài", 23)
    val withResult = with(user) {
        println("Tên : $name, Tuổi : $age")
        age + 2 // kết quả trả về
    }
    println("Kết quả with: $withResult")
}

// also: Dùng khi muốn thực hiện tác vụ phụ (logging, debug) mà không thay đổi đối tượng
fun demoAlso() {
    var user = User1("Bình", 22).also {
        println("Tên: ${it.name}, Tuổi: ${it.age}") // tác vụ phụ
    }
    println("User sau khi also: $user")
}

