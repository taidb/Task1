package com.example.task1.task3.advanced.dsl

import com.example.task1.task3.advanced.reflection.Person

//DSL (Domain Specific Language) cho phép tạo ra một ngôn ngữ dành riêng cho một miền cụ thể,
// giúp việc viết mã ngắn gọn,dễ hiểu hơn.

class PersonBuilder {
    var name: String = ""
    var address: String = ""

    fun build() = Person(name, address)
}

fun person(block: PersonBuilder.() -> Unit): Person {
    val builder = PersonBuilder()
    builder.block()
    return builder.build()
}


class Html {
    private val children = mutableListOf<String>()

    fun body(block: Body.() -> Unit) {
        val b = Body()
        b.block()
        children.add("<body>${b.getContent()}</body>")
    }

    fun render() = children.joinToString("")
}

class Body {
    private val contents = mutableListOf<String>()

    fun p(text: String) {
        contents.add("<p>$text</p>")
    }

    fun getContent() = contents.joinToString("")
}


//hàm mở rộng
fun String.reverse() :String{
    val result = StringBuilder()
    for (i in this.length-1 downTo 0){
        result.append(this[i])
    }
    return result.toString()
}

//scope function
val person =Person("Tài","Nghệ An").apply {
    name="Đặng Bá Tài"
    address="Hà Nội"
}

//Extension function
fun Person.printInfo(){
    println("Name: $name, Address: $address ,Tên đảo ngược : ${name.reverse()}")
}

fun main(){
    val p = person {
        name = "Đặng Bá Tài"
        address = "Hà Nội"
    }
    p.printInfo()

    val html = Html().apply {
        body {
            p("Xin chào Kotlin DSL!")
            p("DSL giúp code dễ đọc hơn")
        }
    }
    println(html.render())

    person.printInfo()

    println("Kotlin DSL".reverse())

}


