package com.example.task1.task1

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
    println("Số nguyên nhỏ nhất byte: $byte")
    println("Số nguyên nhỏ $short")
    println("Số nguyên $a")
    println("Số nguyên lớn nhất : $l")
    println("Số thực $b")
    println("Số thực lớn $c")
    println("Kiểu chuỗi $f")
    println("Kiểu kí tự $e")
    println("Kiểu true false $d")

}

//biến và hằng số
fun variableAndConstant() {
    var name = "Tài"
    var age = 20
    var gender = true
    val pi = 3.14
    // pi =2 -> lỗi// biến val ko được thay đổi giá trị sau khi đã khởi tạo
    name = "Hà"
    println("Tên: $name")
    println("Tuổi: $age")
    println("Giới tính: $gender")
    println("Số PI: $pi")
}

//toán tử
fun demoOperator() {
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
    println("a<19||b<19 = ${a < 19 || b < 19}")
    println("a>19&&b<19 = ${a > 19 && b < 19}")

}

//is : kiểm tra kiểu dữ liệu
fun getLength(str: Any): Int? {
    if (str is String) {
        return str.length
    }
    return null
}

//Ép kiểu
fun dataTypeCoercion() {
    var a = "355"
    var c = a.toInt()
    var d = a.toDouble()
    var e = a.toFloat()
    var k: Int = 2
    var b: Byte = k.toByte()
    var f: Float = k.toFloat()
    var g: Double = k.toDouble()
    var h: Short = k.toShort()
    var l: Long = k.toLong()

    // Ép kiểu an toàn (safe cast)
    val anyValue: Any = "Hello"
    val stringValue = anyValue as? String


    println(getLength(a))
    println(stringValue)
    println("l: $l")
    println("a: $a")
    println("c: $c")
    println("d: $d")
    println("e: $e")
    println("f: $f")
    println("g: $g")
    println("h: $h")
    println("b: $b")

}

//Chuỗi và hàm có sự dụng trong chuỗi kotlin
fun kotlinFunction() {
    val multiLineString = """
    Chuỗi
    nhiều dòng
    trong Kotlin
""".trimIndent()
    println(multiLineString)
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
    println("Có kí tự t trong chuỗi không : ${name.contains("t", ignoreCase = true)}")
    println("Đổi kí tự này sang kí tự khác : ${name.replace("Tài", "Khánh")}")
    println("lấy kí tự tại vị trí ${name[1]}")
    println("Số kí tự trong chuỗi: ${name.length}")
//....
}

fun main() {
    dataType()
    variableAndConstant()
    demoOperator()
    dataTypeCoercion()
    kotlinFunction()
}



