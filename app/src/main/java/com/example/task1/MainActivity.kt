package com.example.task1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {


    private val c: String? = "Buổi 1"
    private val d: Boolean = true
    private val e: Long = 19
    private val f: Double = 6.78
    private val k: Float = 7f

    private val pi: Double = 3.14
    private var age: Int = 20

    // Ép kiểu
    private val x: String = "123"
    private val y: Int = x.toInt()
    private val z: Double = y.toDouble()

    // Collection
    private val numbers = listOf(1, 2, 3, 4, 5)
    private val mutableNumbers = mutableListOf(1, 2, 3)
    private val set = setOf(1, 2, 2, 3, 4)
    private val map = mapOf("name" to "Tai", "age" to 22)
    private val nums = listOf(1, 2, 3, 4, 5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        age += 1
        println("Tuổi sau khi +1: $age")
        println("Pi = $pi, y = $y, z = $z")

        // --------- For Loop ----------
        for (i in 1..5) println("i = $i")
        for (i in 1 until 5) println(" i = $i")


        var n = 5
        while (n > 0) {
            println("While: n = $n")
            n--
        }

        do {
            println("Chạy 1 lần ")
        } while (n > 0)


        mutableNumbers.add(4)
        println("Set = $set")
        println("name :${map["name"]}")

        println("map() x2 = ${nums.map { it * 2 }}")
        println("filter() chẵn = ${nums.filter { it % 2 == 0 }}")
        println("any() có số > 4 không? ${nums.any { it > 4 }}")
        println("all() tất cả > 0 không? ${nums.all { it > 0 }}")
        println("count() số lượng chẵn = ${nums.count { it % 2 == 0 }}")
        println("reduce() tổng = ${nums.reduce { acc, i -> acc + i }}")
        nums.forEach { println("forEach: $it") }
        println("first = ${nums.first()}, last = ${nums.last()}")
        println("find > 3 = ${nums.find { it > 3 }}")


        tinhtong()
        tinhhieu()
        tinhtich()
        tinhthuong()
        tinhdu()
        tinh5()
        tinh6(12)
        inchuoi("Tài")
        checkDay(2)
        checkScore(85)

    }


    private fun tinhtong(a: Int = 5, b: Float = 6f) {
        val c = b.toInt()
        println("Tổng = ${a + c}")
    }

    private fun tinhhieu(a: Int = 5, b: Int = 6) {
        println("Hiệu = ${b - a}")
    }

    private fun tinhtich(a: Int = 5, b: Int = 6) {
        println("Tích = ${a * b}")
    }

    private fun tinhthuong(a: Int = 10, b: Int = 5) {
        println("Thương = ${a / b}")
    }

    private fun tinhdu(a: Int = 7, b: Int = 5) {
        println("Dư = ${a % b}")
    }


    private fun tinh5(a: Int = 7, b: Int = 5) {
        if (a > b) {
            println("a > b")
        } else {
            println("b >= a")
        }
    }

    private fun tinh6(a: Int = 7, b: Int = 5) {
        if (a % 3 == 0 && a % 2 == 0) {
            println("a chia hết cho 6")
        } else {
            println("a KHÔNG chia hết cho 6")
        }
    }


    private fun inchuoi(name: String = "Tai") {
        println("Hello $name")
    }


    private fun checkDay(day: Int) {
        when (day) {
            1 -> println("Thứ hai")
            2 -> println("Thứ ba")
            3 -> println("Thứ tư")
            else -> println("Ngày khác")
        }
    }
    private fun checkScore(score: Int) {
        val grade = when (score) {
            in 90..100 -> "Xuất sắc"
            in 75..89 -> "Giỏi"
            in 50..74 -> "Trung bình"
            else -> "Yếu"
        }
        println("Điểm: $score => Xếp loại: $grade")
    }
}