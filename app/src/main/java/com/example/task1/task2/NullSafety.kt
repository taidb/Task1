package com.example.task1.task2

fun main(){
    //Nullable
    var age :Int? = 23
    println(age)
    var nullable :String?=null
    println("Nullable: $nullable")

    //Non-nullable
    val name :String = "Tài"
    println(name.length)

    //Elvis Operator (?:)
    val score :Double? = null
   val printlnScore:Any = score ?:"Điểm hợp lệ"
   println(printlnScore)

    //Safe Call (?.)
    var specialized :String? = "CNTT"
    println("Độ dài :$specialized?.length")

    // Not-null Assertion (!!)
    val schooll :String ="Trường GTVT"
    println(schooll!!.length)

    //as: là toán tử ép kiểu
    val anyValue: Any = "Hello"
    val str = anyValue as? String
    println(str?.uppercase())
}


