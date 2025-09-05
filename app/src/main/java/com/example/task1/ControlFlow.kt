package com.example.task1



    //for
    fun forflower() {
        var listFlower = listOf("rose", "tulip", "lily")
        println("Danh sách hoa:")
        for (flower in listFlower) {
            print(flower+" ")
        }
        println()
        println("Danh sách hoa:")
        listFlower.forEach { flower -> print(flower+" ") }
        listFlower.forEach{ println(it) }
        println()
        println("Danh sách hoa:")
        for (i in listFlower.indices) {
            print(listFlower[i]+" ")
        }
        for (i in listFlower.indices step 2) {
            println(listFlower[i]+" ")
        }

        println("In từ 1 đến 10:")
        for (i in 1..10) {
            println(i)
        }
        println("In từ 1 đến 9:")
        for (i in 1 until 10) {
            println(i)
        }
        println("In từ 10 đến 1:")
        for (i in 10 downTo 1) {
            println(i)
        }
    }

    //if else
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

    //While
    fun whileFlower() {
        var listFlower = listOf("rose", "tulip", "lily")
        var i = 0
        println("Danh sách hoa:")
        while (i < listFlower.size) {
            print(listFlower[i]+" ")
            i++
        }
    }

        //when
        fun whenTest() {
            var a = "thứ hai"
            println()
            when (a) {
                "thứ hai" -> println("Hôm nay thứ 2")
                "thứ ba" -> println("Hôm nay thứ 3")
                "thứ tư" -> println("Hôm nay thứ 4")
            }
        }

        //do while
        fun dowhileFlower() {
            var listFlower = listOf("rose", "tulip", "lily")
            var i = 0
            println("Danh sách hoa:")
            do {
                print(listFlower[i]+" ")
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

        fun main() {
            forflower()
            conditional()
            whileFlower()
            whenTest()
            dowhileFlower()
            breakTest()
            continueTest()
        }



