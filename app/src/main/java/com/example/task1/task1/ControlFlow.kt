package com.example.task1.task1

//if else thông thường
fun conditional() {
    var a = 6
    var b = 7
    if (a.equals(b)) {
        println("a=b")
    } else if (a > b) {
        println("a>b")
    } else {
        println("a<b")
    }
}

//if else như biểu thức trả về giá trị
fun conditionalReturnValue(): Int {
    val a = 6
    val b = 7
    val max = if (a > b) a else b
    return max
}


fun conditional2() {
    var a = 3
    var b = 10
    if (6 in a..b) {
        println("6 nằm trong khoảng từ a đến b")
    }
}

//when
fun whenExample() {
    var a = "thứ hai"
    when (a) {
        "thứ hai" -> println("Hôm nay thứ 2")
        "thứ ba" -> println("Hôm nay thứ 3")
        "thứ tư" -> println("Hôm nay thứ 4")
        else -> throw IllegalArgumentException("Lỗi")
    }
}
//When nâng cao
fun whenAdvanced(x: Any) {
    when (x) {
        0, 1 -> println("x là 0 hoặc 1")
        in 2..10 -> println("x trong khoảng 2 đến 10")
        !in 11..20 -> println("x không nằm trong 11..20")
        is String -> println("x là chuỗi dài ${x.length}")
        else -> println("Không khớp")
    }
}

//for
fun demonForLoop() {
    var listFlower = listOf("rose", "tulip", "lily")
    listFlower.forEachIndexed { index, flower -> println("$index:$flower") }

    listFlower.forEach { flower -> print(flower + " ") }

    listFlower.forEach { println(it) }
    println()

    println("Danh sách hoa:")
    for (flower in listFlower) {
        print(flower + " ")
    }

    val language = listOf("Kotlin", "Java", "Dart")

    for ((index, value) in language.withIndex()) {
        println("Phần tử thứ $index là $value")
    }


    println("Danh sách hoa:")
    for (i in listFlower.indices) {
        print(listFlower[i] + " ")
    }
    for (i in listFlower.indices step 2) {
        println(listFlower[i] + " ")
    }

    println("In từ 1 đến 10:")
    for (i in 1..10) {
        println(i)
    }

    println("in từ 1 đến 10 không bao gồm số 10")
    for (i in 1..< 10) {
        print(i)
    }
    println("In danh sách :")
    (1..10).forEach { println(it) }

    println("In từ 1 đến 9:")
    for (i in 1 until 10) {
        println(i)
    }
    println("In từ 10 đến 1:")
    for (i in 10 downTo 1) {
        println(i)
    }

}

//While
fun whileFlower() {
    var listFlower = listOf("rose", "tulip", "lily")
    var i = 0
    println("Danh sách hoa:")
    while (i < listFlower.size) {
        print(listFlower[i] + " ")
        i++
    }
}


//do while
fun dowhileFlower() {
    var listFlower = listOf("rose", "tulip", "lily")
    var i = 0
    println("Danh sách hoa:")
    do {
        print(listFlower[i] + " ")
        i++
    } while (i < listFlower.size)
}

//break
fun breakTest() {
    println("In đến 7 thì dừng:")
    for (i in 1..10) {
        if (i == 7) {
            break
        }
        println(i)
    }
}

//continue
fun continueTest() {
    println()
    println("Bỏ qua số 7:")
    for (i in 1..10) {
        if (i == 7) {
            continue
        }
        println(i)
    }

}

class User(val name: String, val role: String)


fun main() {
    demonForLoop()
    conditional()
    println("So sánh a và b : ${conditionalReturnValue()}")
    whileFlower()
    whenExample()
    dowhileFlower()
    breakTest()
    continueTest()


}



