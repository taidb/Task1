package com.example.task1.task3.coroutines

import com.example.task1.task3.higherorder.measureTime
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun demoCoroutine() {
    //Coroutine :
    runBlocking { // this: CoroutineScope
        //CouroutineScope
        launch {       //coroutine 1
            delay(500L)
            println("Task from launch")
        }
        runBlocking {
            delay(100)
            println("Task from runBlocking1")

            launch {
                delay(600L)
                println("Task from launch in runBlocking")
            }
        }
        coroutineScope {
            launch {
                delay(200L)
                println("Task from launch in CoroutineScope")
            }

            delay(1000L)
            println("Task from coroutine scope")
        }
        println("Coroutine scope is over")
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun demoGlobalScope() {
    //GlobalScope: chạy xu
    runBlocking {
        val request =
            launch {
                GlobalScope.launch {
                    println("job1:GlobalScope and execute here")
                    delay(500L)
                    println("job1:GlobalScope after cancel")
                }
                launch {
                    delay(100)
                    println("job2:launch child of the request coroutine")
                    delay(1000)
                    println("job2:will not execute this line if job1 is cancelled")
                }
            }
        delay(500)
        request.cancel()
        delay(1000)
        println("main: Who has survived request cancellation?")
    }
}

fun demoSuspendFunction() {
//suspend function
    runBlocking {
        val time = measureTime {
            val result1 = task1()
            val result2 = task2()
            println("Result 1: $result1")
            println("Result 2: $result2")
            println("Giá trị tổng: ${result1 + result2}")

        }
        println("Thời gian thực thi: $time ms")

        doWorld()
        println("Done")

        //Muốn cả 2 thực hiện dồng thời sự dụng : async
        val time2 = measureTimeMillis {
            val one = async { task1() }
            val two = async { task2() }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time2 ms")

        //Lazily started async : chỉ khởi động coroutine khi kết quả của nó được yêu cầu bởi await
        val time3 = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { task1() }
            val two = async(start = CoroutineStart.LAZY) { task2() }
            one.start()
            two.start()
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time3 ms")
        println("Demo thực thi Với Xử lý Ngoại lệ ${executeWithExceptionHandling()} ")
    }
}

fun demoReturnJob() {
    runBlocking {
        launch { // launch tạo 1 couroutine mới nó sẽ trả về 1 job cái này nó sẽ ko trả về kết quả mà nó sẽ quản lí vòng đời của couroutine đó
            delay(1000L)
            println("World1!")
        }
        println("Hello1") // main coroutine continues while a previous one is delayed

        //A launch coroutine builder returns a Job
        val job = launch { // launch a new coroutine and keep a reference to its Job
            delay(2000L)
            println("World2!")
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
        println("Hủy job")
        job1.cancel()
        job1.join()
        println("Done")

        //khối finally để đóng resource ngay cả khi couroutine bị hủy
        val job3 = launch {
            try {
                repeat(1000) {
                    println("Job :$it")
                    delay(500)
                }
            } finally {
                //withContext(NonCancellable){ -> có theer sự dụng cái này để có thể chạy mặc dù đã bị hủy
                println("start finally")
                delay(1000) //delay có khả nawng check xem coroutine còn sống không
                println("end finally")
            }
        }
        delay(1200L)
        println("main: cancel job")
        job3.cancel()
        println("Main")

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
    }
}

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
fun demoWithContext() {//sử dụng hàm withContext() từ thư viện coroutine để di chuyển quy trình thực thi của coroutine sang một luồng khác
    runBlocking {
        //Dispatcher
        println("Hiện đang chạy Thread :${Thread.currentThread().name}")
        val result1 = withContext(newSingleThreadContext("MyOwnThread")) {
            println("Hiện đang chạy Thread :${Thread.currentThread().name}")
            "Xong với Unconfined"
        }
        println(result1)
        val result2 =
            withContext(Dispatchers.IO) { // sự dụng để thực hiện I/O đĩa hoặc I/O mạng bên ngoài luồng chính.
                println("Hiện đang chạy Thread :${Thread.currentThread().name}")
                "Xong với IO"
            }
        println(result2)
        val result3 =
            withContext(Dispatchers.Default) { // được tối ưu hoá để thực hiện tác vụ nặng về CPU bên ngoài luồng chính.
                println("Chạy withContext(Dispatchers.Default) :${Thread.currentThread().name}")

                val one = this.async {
                    println("Hiện đang chạy Thread :${Thread.currentThread().name}")
                    val sum = (1..500_000).sum()
                    delay(200)
                    println("Hiện đang chạy Thread :${Thread.currentThread().name}")
                    sum
                }
                val two = this.async {
                    println("Hiện đang chạy Thread :${Thread.currentThread().name}")
                    val sum = (500_000..1_000_000).sum()
                    delay(200)
                    println("Hiện đang chạy Thread :${Thread.currentThread().name}")
                    sum
                }
                println("Tổng :${one.await() + two.await()}")
                //Unconfined khi gặp 1 hàm tạm dừng nó sẽ tiếp tục trên bất kì luồng nào mà hàm tạm dừng đó được gọi
                // -> không giới hạn luồng cụ thể phù hợp với các tác vụ không tốn CPU, không cập nhật UI hoặc dữ liêu chung
                val result4 = launch(Dispatchers.Unconfined) {
                    println("Hiện đang chạy Thread :${Thread.currentThread().name}")
                    delay(200)
                    println("Hiện đang chạy Thread :${Thread.currentThread().name}")
                }
                println(result4)
                launch { // context of the parent, main runBlocking coroutine
                    println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
                    delay(1000)
                    println("main runBlocking: After delay in thread ${Thread.currentThread().name}")

                }
            }
        println(result3)

        //jumping betwwen threads
        newSingleThreadContext("Ctx1").use { ctx1 ->
            newSingleThreadContext("Ctx2").use { ctx2 ->
                runBlocking(ctx1) {
                    log("is running in ctx1")
                    withContext(ctx2) {
                        log("is running in ctx2")
                    }
                    log("Back to ctx1")
                }
            }
        }
        //Timeout : Hủy thực thi 1 couroutine
        val result0 =
            withTimeoutOrNull(1200) { //withTimeoutOrNull nó trả về null nếu hết giờ
                repeat(1000) { i ->
                    println("job: $i ...")
                    delay(500L)
                }
                "Done"
            }
        println("Result is $result0")
    }

}

fun demo() {
    runBlocking {
        launch {
            //Parental responsibilities
            val request1 = launch {
                repeat(3) { i ->
                    launch {
                        delay((i + 1) * 200L)
                        println("Coroutine $i is done")
                    }
                }
                println("request: I'm done and I don't explicitly join my children that are still active")
            }
            request1.join()
            println("Now processing of the request is complete")

            //Naming coroutines để gỡ lỗi
            log("Started main coroutine")
            val v1 = async(CoroutineName("v1coroutine")) {
                delay(500)
                log("Computing v1")
                252
            }
            val v2 = async(CoroutineName("v2coroutine")) {
                delay(1000)
                log("Computing v2")
                6
            }
            log("The answer for v1 / v2 = ${v1.await() / v2.await()}")

            //Kết hợp ngữ cảnh : cần định nghĩa nhiều phần tử cho một ngữ cảnh coroutine
            launch(Dispatchers.Default + CoroutineName("test")) {
                println("I'm working in thread ${Thread.currentThread().name}")
            }
        }
    }
}

fun main() {
    demoCoroutine()
    demoGlobalScope()
    demoSuspendFunction()
    demoReturnJob()
    demoWithContext()
    demo()
}
