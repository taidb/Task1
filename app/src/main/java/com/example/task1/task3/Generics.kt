package com.example.task1.task3

//Generics thông thường
class Box<T : Number>(private var a: T, private var b: T) {
    fun getValue(): Number {
        return when (a) {
            is Int -> a.toInt() * b.toInt()
            is Double -> a.toDouble() * b.toDouble()
            is Float -> a.toFloat() * b.toFloat()
            else -> throw IllegalArgumentException("Lỗi")

        }
    }
}
//out - in trong generics
class OutClass<out T>(val value: T) {
    fun get(): T = value
}

val out = OutClass("string")
val ref1: OutClass<Any> = out


class InClass<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}

val inClassObject: InClass<Number> = InClass()
val ref2: InClass<Int> = inClassObject