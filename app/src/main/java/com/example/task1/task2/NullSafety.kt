package com.example.task1.task2

fun main(){
    //Nullable: Ví dụ nhập tuổi từ form, có thể để trống
    var age :Int? = 23
    println(age)
    var nullable :String?=null
    println("Nullable: $nullable")

    //Non-nullable: dữ liệu chắc chắn có (ví dụ: tên luôn có)
    val name :String = "Tài"
    println("Tên app: $name - số ký tự: ${name.length}")

    // Elvis Operator (?:) - dùng khi dữ liệu có thể null và cần giá trị thay thế
    val score: Double? = null
    val displayScore: Any = score ?: "Chưa có điểm thi"
    println("Điểm thi: $displayScore")

    // Safe Call (?.) - tránh crash khi null
    var specialized: String? = "Công nghệ thông tin"
    println("Tên ngành: $specialized - độ dài: ${specialized?.length ?: 0}")

    // Not-null Assertion (!!) - chỉ dùng khi chắc chắn dữ liệu không null
    val schooll :String ="Trường GTVT"
    println(schooll!!.length)

    // as? - Ép kiểu an toàn: dùng khi dữ liệu có thể là nhiều loại
    val anyValue: Any = "Hello World"
    val str = anyValue as? String
    println("Giá trị chuỗi in hoa: ${str?.uppercase() ?: "Không phải String"}")
}


