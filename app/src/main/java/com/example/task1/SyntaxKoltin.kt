package com.example.task1

//kiểu dữ liệu
fun dataType() {
    var a: Int = 0
    var b: Float = 0f
    var c: Double = 5.0
    var l: Long = 1234567890L
    var short: Short = 123
    var byte: Byte = 127
    var d: Boolean = true
    var f: String = "Cảm ơn anh đã xem bài em ạ!"
    var e: Char = 'v'
    println("Số nguyên nhỏ nhatass byte: $byte")
    println("Số nguyên nhỏ $short")
    println("Số nguyên $a")
    println("Số nguyên lớn nhất : $l")
    println("Số thực $b")
    println("Số thực lớn $c")

}

// kiểu khai báo có thể suy luận ra kiểu dữ liệu và hắng sô
fun automaticAndConstant() {
    var name = "Tài"
    var age = 20
    var gender = true
    var pi = 3.14
    println("Tên: $name")
    println("Tuổi: $age")
    println("Giới tính: $gender")
    println("Số PI: $pi")
}

//toán tử
fun operator() {
    var a = 10
    var b = 5
    var c = a + b
    var d = a - b
    var e = a * b
    var f = a / b
    var g = a % b

    println("Tổng $a + $b = $c")
    println("Hiệu $a - $b = $d")
    println("Tích $a * $b = $e")
    println("Thương $a / $b = $f")
    println("Phần dư $a % $b = $g")
    println("a^b = ${Math.pow(a.toDouble(), b.toDouble())}")

    // có thể sự dụng các hàm sẵn
    println("Tổng $a + $b =${a.plus(b)}")
    println("Hiệu ${a.minus(b)}")
    println("Thương: ${a.div(b)}")
    println("Tích ${a.times(b)}")
    println("Du ${a.rem(b)}")

    println("a++ = ${a++}")
    println("${a}")
    println("++a = ${++a}")
    println("$a")
    println("a-- = ${a--}")
    println("--a = ${--a}")
    println("a==b = ${a == b}")
    println("a!=b = ${a != b}")
    println("a>b = ${a > b}")
    println("a<b = ${a < b}")
    println("a>=b = ${a >= b}")
    println("a<=b = ${a <= b}")
    println("a>19&&b<19 = ${a > 19 && b < 19}")

}

//Ép kiểu
fun dataTypeCoercion() {
    var a = "355"
    var c = a.toInt()
    var d = a.toDouble()
    var e = a.toFloat()
    println("a: $a")
    println("c: $c")
    println("d: $d")
    println("e: $e")

}

//hàm có sự dụng trong chuỗi kotlin
fun kotlinFunction() {
    var name = "Đặng Bá Tài"
    println("Tên tôi là $name")
    println("Lấy kí tự đầu tiên: ${name.first()}")
    println("Lấy kí tự cuối cùng: ${name.last()}")
    println("Lấy 3 kí tự đầu tiên: ${name.take(3)}")
    println("Lấy 3 kí tự cuối cùng: ${name.takeLast(3)}")
    println("lấy kí 3 kí đầu tiên : ${name.substring(0, 3)}")
    println("In hoa tất cả :${name.uppercase()}")
    println("Chuyển veef kí tự thường : ${name.lowercase()}")
    println("lấy kí tự tại vị trí ${name.elementAt(1)}")
    println("lấy kí tự tại vị trí ${name[1]}")
    println("Số kí tự trong chuỗi: ${name.length}")
//....
}

fun main() {
    dataType()
    automaticAndConstant()
    operator()
    dataTypeCoercion()
    kotlinFunction()
}



