package com.example.task1.task3.advanced.reflection

//Tham chiếu hàm
fun isOdd(x: Int) = x % 2 != 0
fun isOdd(s: String) = s == "brillig" || s == "sli" || s == "Hi"
fun length(s: String) = s.length

// Có thể cung cấp ngữ cảnh bằng cách lưu trữ tham chiếu phương thức trong 1 biến
val predicate: (String) -> Boolean = ::isOdd

//sự dụng 1 thành viên của 1 lớp hay 1 hàm mở rộng cần xác định rõ String ::ToCharArray
val isEmptyStringList: List<String>.() -> Boolean = List<String>::isEmpty

//Hàm kết hợp
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

//Truy cập thuộc tính của chương trinhf
var name = Person("Nguyễn Văn A", "Hà Nội").name

//Hàm mở rộng
val String.lastChar:Char
    get()= this[length-1]


fun main() {
    val kPreson = Person::class
    println(kPreson.simpleName)

    val number = listOf(1, 2, 3, 4, 5)
    println(number.filter(::isOdd))

    println(predicate("brillig"))

    println(isEmptyStringList(listOf("Tài", "Đặng")))
    println(isEmptyStringList(listOf()))

    val oddLength = compose(::isOdd, ::length)
    val str = listOf("Tài", "Đặng", "Bá")
    println(str.filter(oddLength))

    ::name.set("Nguyễn văn B")
    println(::name.get())
    println(::name.name)

    //truy cập vào 1 lớp :
    val address = Person::address
    println(address.get(Person("Nguyễn Văn A", "Hà Nội")))
    address.set(Person("Nguyễn Văn A", "Hà Nội"), "Nghệ An")

    println(String::lastChar.get("Nguyễn Văn A"))

    //tham chiếu hàm và thuộc tính ràng buộc
    val numberRegex = "\\d+".toRegex()
    val strings= listOf("abc","124","a70")
    println(strings.filter(numberRegex::matches))

    val isNumber: (CharSequence) ->Boolean =numberRegex::matches
    val matches :(Regex,CharSequence) ->Boolean = Regex::matches

    println(isNumber("29"))
    println(matches(numberRegex,"29"))

    //một tham chiếu thuộc tính cuũng có thể đươợc ràng buộc
    val prop = "abc"::length
    println(prop.get())

}

