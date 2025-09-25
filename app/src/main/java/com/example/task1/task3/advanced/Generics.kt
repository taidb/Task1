    package com.example.task1.task3.advanced

    //Tạo lớp sự dụng Generic
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

    // Generic trong function
    fun <T> printValue(value: T) {
        println("Value = $value")
    }

    //Generics trong interface
    interface Repository<T>{
        fun add(item:T)
        fun getId(id:Int):T
    }

    // Implement Repository với kiểu cụ thể
    class User(val id: Int, val name: String)

    class UserRepository : Repository<User> {
        private val users = mutableListOf<User>()

        override fun add(item: User) {
            users.add(item)
        }

        override fun getId(id: Int): User {
            return users.first { it.id == id }
        }
    }


    //out - in trong generics
    class OutClass<out T>(private val value: T) {
        fun get(): T = value
    }

  //  val out = OutClass("string")
//    val ref1: OutClass<Any> = out


    class InClass<in T> {
        fun toString(value: T): String {
            return value.toString()
        }
    }

  //  val inClassObject: InClass<Number> = InClass()
//    val ref2: InClass<Int> = inClassObject