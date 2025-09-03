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
    private val k: Float = 7f

    private val pi: Double = 3.14
    private var age: Int = 20

    // Ép kiểu
    private val x: String = "123"
    private val y: Int = x.toInt()
    private val z: Double = y.toDouble()

    // Collection
    private val mutableNumbers = mutableListOf(1, 2, 3)

    private val set = setOf(1, 2, 2, 3, 4)
    private val map = mapOf("name" to "Tai", "age" to 22)
    private val nums = listOf(1, 2, 3, 4, 5)

    val students = listOf(
        Student(1, "An", 80),
        Student(2, "An", 45),
        Student(3, "Chi", 100),
        Student(4, "Dũng", 30),
        Student(5, "Hà", 75),
        Student(6, "Hùng", 49),
        Student(7, "Lan", 90),
        Student(8, "Minh", 55),
        Student(9, "Nga", 20),
        Student(10, "Tú", 70)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("1.in danh sách sinh viên")
        printStudentDoWhile()
        println("2.chuyển thành kiểu id,Student")
        saveStudentToMap()

        println("4.in xếp loại sinh viên")
        ratingStudent()
        println("5.in điểm trung bình")
        printAvgScore()
        println("6.Tìm kiếm sinh viên tên An")
        sreachStudentByName("An")
        println("7.in Danh sách sinh viên đậu ,rớt")
        printFailedAndPassStudent()
        println("8.in xếp loại sinh viên")
        ratingStudent()
        println("9.in sinh viên có điểm thấp nhất, điểm cao nhất")
        printHighestAndLowestScore()
        println("10.Lọc sinh viên có lớn hơn 85")
        filterStudent()
        println("11.Số sinh viên trượt")
        countStudent()
        println("12.Kiểm tra sinh viên nào có điểm 100")
        if (checkAnyStudent()) println("có sinh viên  có điểm 100") else println("Không có sinh viên có điểm 100")
        println("13.Kiểm tra tất cả sinh viên có điểm lớn hơn 30")
        if (checkAllStudent()) println("Tất cả sinh viên có điểm lớn hơn 30") else println(
            "Không tất cả sinh viên có điểm lớn hơn 30"
        )
        println("14.Sắp xếp sinh viên theo điểm tăng dần")
        sortAscendingStudent()
        println("15.Sắp xếp sinh viên theo điểm giảm dần")
        sortDescendingStudent()
        println("16.In  sinh viene đầu tiên")
        printFirstStudent()
        println("17.In  sinh viên cuối cùng")
        printLastStudent()
        println("18.Chuyển tên sinh viên in hoa")
        transferToUppercase()
        println("19.Chuyển kiểu dữ liệu")
        chageStyle()
        println("20. In sinh viên có tên là An điểm cao hơn 50")
        printStudentdemand()
        println("21. In sinh viên có tên là An hoặc có điểm bằng 100")
        printStudentdemand2()
        println("22.Tổng điểm 2 sinh viên đầu tiên")
        sumScoreTwoStudentFirst()
        println("23.Tích điểm 2 sinh viên đầu tiên")
        multiplicationScoreTwoStudentFirst()
        println("24.In danh sách sinh viên ở id lẻ")
        printStudentOdd()
        println("\n")



    }

    fun printStudentOdd() {
        students.forEach {
            if (it.id % 2 != 0) {
                println("Danh sách sinh viên lẻ : $it")
            }
        }
    }

    fun printStudentdemand() {
        students.forEach {
            if (it.name == "An" && it.score >= 50) {
                println("Danh sách sinh viên : $it")
            }
        }
    }

    fun printStudentdemand2() {
        students.forEach {
            if (it.name == "An" || it.score >= 100) {
                println("Danh sách sinh viên : $it")
            }
        }
    }

    fun printStudent() {
        for (i in 0..students.size) {
            println("${i + 1} ${students[i]}")
        }
    }

    fun saveStudentToMap() {
        var mapStudents = mutableMapOf<Int, Student>()
        students.forEach {
            mapStudents[it.id] = it
        }
        println("Map sinh viên: $mapStudents")
    }

    fun sreachStudentByName(name: String) {
        students.forEach {
            if (it.name == name) {
                println("Sinh viên có tên $name là $it")
            }
        }
    }

    fun printFailedAndPassStudent() {

        var i = 0
        while (i < students.size) {
            if (students[i].score >= 50) {
                println("Tên ${students[i].name} id ${students[i].id} điểm ${students[i].score} : Đậu")
            } else {
                println("Tên ${students[i].name} id ${students[i].id} điểm ${students[i].score} : Rớt")
            }
            i++
        }

    }

    fun ratingStudent() {
        for (i in students) {
            when (i.score) {
                in 90..100 -> println("Tên ${i.name} id ${i.id} điểm ${i.score} : Xuất sắc")
                in 80..89 -> println("Tên ${i.name} id ${i.id} điểm ${i.score} : Giỏi")
                in 70..79 -> println("Tên ${i.name} id ${i.id} điểm ${i.score} : Khá")
                in 50..69 -> println("Tên ${i.name} id ${i.id} điểm ${i.score} : Trung bình")
                else -> println("Tên ${i.name} id ${i.id} điểm ${i.score} : Yếu")
            }

        }
    }

    fun printAvgScore() {
        var sum = 0
        var d = 0
        for (i in students) {
            sum += i.score
            d++
        }
        val avg = sum / d
        println("Điểm trung bình 1 là $avg")
        students.sumOf { it.score }// tính tổng điểm sinh viên
        val avg1 = students.sumOf { it.score } / students.size
        val totalScore = students.map { it.score }.reduce { acc, i -> acc + i }
        val avg2 = totalScore.toDouble() / students.size
    }

    fun printHighestAndLowestScore() {
        // in sinh viên có điểm thấp nhất
        println("Điểm thấp nhất là ${students.minOf { it.score }} của ${students.minBy { it.score }.name}}")
        //in sinh viên có điểm cao nhất
        println("Điểm cao nhất là ${students.maxOf { it.score }} của ${students.maxBy { it.score }.name}}")
    }

    fun filterStudent() {
        println(
            "Danh sách sinh viển có điểm lớn hơn 85 : ${students.filter { it.score >= 85 }} của ${
                students.filter { it.score >= 85 }.map { it.name }
            }"
        )
    }

    fun countStudent() {
        //Đếm số sinh viên trượt
        println("Số sinh viên đõ là ${students.count { it.score >= 50 }} Số sinh viên trượt là ${students.count { it.score <= 50 }}")
    }

    fun checkAnyStudent(): Boolean {
        //kiểm tra có sinh viên nào có điểm 100
        return students.any { it.score >= 100 }
    }

    fun checkAllStudent(): Boolean {
        return students.all { it.score >= 30 }
    }

    // kieem tra  tất cả sinh viên có điểm lớn hơn 30
    fun sortAscendingStudent() {
        //Sắp xếp sinh viên theo điểm tăng dần
        println("Sắp xếp sinh viên theo điểm tăng dần : ${students.sortedBy { it.score }}}")
    }

    fun sortDescendingStudent() {
        //Sắp xếp sinh viên theo điểm giảm dần
        println("Sắp xếp sinh viên theo điểm giảm dần : ${students.sortedByDescending { it.score }}}")
    }

    fun printFirstStudent() {
        println("Sinh viên đầu tiên là :${students.first()}")
        println("Sinh viên đầu tiên là :${students.take(1)}")
    }

    fun printLastStudent() {
        println("Sinh viên cuối cùng là :${students.takeLast(1)}")

        println("Sinh viên cuối cùng là :${students.last()}")
    }

    fun printStudentAt() {
        println("Sinh viên thứ 2 là :${students.elementAt(1)}")
    }

    fun transferToUppercase() {
        println("Danh sách sinh viên : ${students.map { it.name.uppercase() }}")
    }

    fun chageStyle() {
        println("Ép điểm sinh viên sang Double : ${students.map { it.score.toDouble() }}")
        println("Ép id sinh viên sang String : ${students.map { it.score.toString() }}")
    }

    fun sumScoreTwoStudentFirst() {
        println("Tổng điểm của hai sinh viên đầu tiên là : ${students[0].score + students[1].score}")
    }

    fun multiplicationScoreTwoStudentFirst() {
        println("Tích điểm của hai sinh viên đầu tiên là : ${students[0].score * students[1].score}")
    }

   fun printStudentDoWhile() {
        var i = 0
        do {
            println("Sinh viên thứ $i là : ${students[i]}")
            i++
        } while (i < students.size)
   }
}


