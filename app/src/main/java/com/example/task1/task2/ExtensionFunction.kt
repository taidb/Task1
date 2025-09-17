package com.example.task1.task2


//Extension Function
fun String.reverseString(): String {
    return this.reversed()
}

fun String.capitalizeFirst(): String =
    if (this.isNotEmpty()) this[0].uppercase() + this.substring(1) else this


fun String.lengthString(): Int {
    return this.length
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    var temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}


