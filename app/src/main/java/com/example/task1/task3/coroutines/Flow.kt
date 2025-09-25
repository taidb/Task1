package com.example.task1.task3.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

// Cold Flow
fun simple(): Flow<Int> = flow {
    //nhận nhiêu giá trị theo thời gian,chỉ chạy được khi gọi collect
    //Flow sử dụng hàm suspend để taoj và xử lý giá trị,giúp tạo ra các yêu cầu mạng hoặc tác vụ tốn thời gian mà không chặn luồng chính
    for (i in 1..3) {
        delay(500)
        emit(i)
    }
}

suspend fun performRequest(request: Int): String {
    delay(1000)
    return "response $request"
}

fun number(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        emit(3)
    } finally {
        println("Finally in numbers")
    }
}

//flow tuân thủ thuoocj tính bảo toàn ngữ cảnh và không được phép emit từ các ngữ cảnh khác nên ko sự duụng withContext để thay đổi
fun simple1(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun demoColdFlow() {
    runBlocking {
        launch {
            for (k in 1..3) {
                println("I'm not blocked $k")
                delay(100)
            }
        }

        println("Collector 1 bắt đầu")
        simple().collect { println("Collector 1 nhận: $it") }

        println("Collector 2 bắt đầu")
        simple().collect { println("Collector 2 nhận: $it") }
        // Collect the flow
        simple().collect { value -> println(value) }

        //Sự dụng asFlow() có thể chuyển đổi một danh sách thành một luồng
        (1..5).asFlow().collect { value -> println(value) }

        //map,filter khác biệt khi sự dụng với chuỗi là nó có thể gọi các hàm suspend
        (1..5).asFlow()
            .filter {
                println("Filter $it")
                it % 2 == 0
            }
            .map {
                println("Map $it")
                "string $it"
            }.collect {
                println("Collect $it")
            }

        //transform nó mô phỏng lại map và filter và có thể thực hiện nhiều phép biến đổi phức tạp hơn
        (1..5).asFlow().transform { value ->
            emit("Giá trị: $value")
            emit(performRequest(value))
        }.collect { value -> println(value) }

        //take: Giới hạn kích thước sẽ hủy flow khi đạt đến giới hạn
        number().take(2).collect { value ->
            println(value)
        }

        //Có thể chuyển đổi thành nhiều collection khác : toList,toSet
        //chuyển thành 1 giá trị duy nhất : reduce,fold
        val sum = (1..5).asFlow().map { it * it }.reduce { a, b -> a + b }
        println(sum)

        simple1().collect { value -> println(value) }

        //conflate : bỏ qua các giá trị trung gian khi collector chậm để xử lí
        val time = measureTimeMillis {
            simple().conflate().collect { value ->
                delay(300)
                println(value)
            }
        }
        println("Collected in $time ms")

        //Buffering: chạy các phần khác nhau của 1 flow trong các couroutine khác nhau có thể sẽ giảm thời gian chạy
        val time1 = measureTimeMillis {
            simple().buffer().collect { value ->
                delay(300)
                println(value)
            }
        }
        println("Collected in $time1 ms")

        //zip kết hợp các giá trị tương ứng của 2 flow
        val nums = (1..2).asFlow()
        val str = flowOf("Apple", "Banana")
        nums.zip(str) { a, b -> "$a -> $b" }.collect { println(it) }


    }
}

fun demoHotFlow() {
    //Hot Flow (StateFlow,SharedFlow)
    runBlocking {
        val sharedFlow = MutableSharedFlow<Int>() //nhiều collector cùng nhận sự kiện

        // Collector 1
        launch {
            sharedFlow.collect { println("Collector 1 nhận: $it") }
        }

        // Collector 2
        launch {
            sharedFlow.collect { println("Collector 2 nhận: $it") }
        }

        delay(500)
        sharedFlow.emit(100)
        sharedFlow.emit(200)
    }
    fun sharedFlowExample() = runBlocking {
        val shared = MutableSharedFlow<Int>(replay = 0) // không lưu lại giá trị cũ nếu replay là n thì nó sẽ lưu n lần gần nhất emit

        launch {
            delay(500)
            shared.collect { println("Collector 1 nhận: $it") }
        }

        shared.emit(1)
        shared.emit(2)
        delay(1000)
        shared.emit(3)
    }
    println(sharedFlowExample())
    runBlocking {
        val stateFlow =
            MutableStateFlow(0) // giữ giá trị cuối cùng lưu trữ trangj thái hiện tại

        // Collector 1
        launch {
            stateFlow.collect { println("Collector 1 nhận: $it") }
        }

        delay(500)
        stateFlow.value = 1
        stateFlow.value = 2

        // Collector 2 đến sau
        launch {
            stateFlow.collect { println("Collector 2 nhận: $it") }
        }

        delay(500)
        stateFlow.value = 3
    }

}

fun main() {
    demoColdFlow()
    demoHotFlow()
}

