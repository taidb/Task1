package com.example.task1.task2


//error :Chỉ ra một trạng thái hoặc điều kiện bất hợp pháp(IllegalStateException)
fun processUserRole(user: com.example.task1.task1.User) {
    when (user.role) {
        "admin" -> println("${user.name} is an admin.")
        "editor" -> println("${user.name} is an editor.")
        "viewer" -> println("${user.name} is a viewer.")
        else -> error("Undefined role: ${user.role}")
    }
}

//require: kiểm tra tính hợp lệ của thông tin đầu vào(khi thông tin rất quan trọng đối với hoạt động) (IllegalArgumentException)
fun getIndices(count: Int): List<Int> {
    require(count > 0) { "số phải lớn hơn 0" }
    return List(count) { it + 1 }
}

//Check(): kiểm tra tính hợp lệ của 1 trạng thái hoặc đối tưởng
fun checkInt(count: Int): Int {
    check(count > 0) { "số phải lớn hơn 0" }
    return count
}