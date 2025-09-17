package com.example.task1.task3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    //Coroutine :
    runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello1") // main coroutine continues while a previous one is delayed


        //A launch coroutine builder returns a Job
        val job = launch { // launch a new coroutine and keep a reference to its Job
            delay(1000L)
            println("World!")
        }
        println("Hello2")
        job.join() // đợi cho đến khi coroutine hoàn thành
        println("Done")

        //Hủy thực thi couroutine
        val job1 = launch {
            repeat(1000) { i ->
                println("job: $i ...")
                delay(500L)
            }
        }
        delay(1200L)
        println("Huủy job")
        job1.cancel()
        job1.join()
        println("Done")

        //inActive : kiểm tra trạng thái hủy nó trả về false khi couroutine bị hủy
        val startTime = System.currentTimeMillis()
        val job2 = launch(Dispatchers.Default) {
            var newPrintTime = startTime
            var i = 0
            while (isActive) {
                if (System.currentTimeMillis() >= newPrintTime) {
                    println("Job: ${i++}")
                    newPrintTime += 500L
                }
            }
        }
        delay(1200L)
        println("main: cancel job")
        job2.cancelAndJoin()
        println("Main")

        //Dispatcher
        println("Hiện đang chạy Thread :${Thread.currentThread().name}")
        var result2 = withContext(Dispatchers.IO) {
            println("Hiện đang chạy Thread :${Thread.currentThread().name}")
            "Xong với IO"
        }
        var result3 = withContext(Dispatchers.Default) {
            println("Hiện đang chạy với Thread :${Thread.currentThread().name}")
            "Xong với Default"
        }
    }


}
