package com.example.task1.task3.advanced

import com.example.task1.task3.advanced.enum.Cards
import com.example.task1.task3.advanced.enum.DAYS
import com.example.task1.task3.advanced.enum.TrafficLight
import com.example.task1.task3.advanced.enum.Weather
import com.example.task1.task3.advanced.sealedclass.ApiResponse
import com.example.task1.task3.advanced.sealedclass.Screen


//Sealed Class
fun handleApiResponse(result: ApiResponse<String>) {
    when (result) {
        is ApiResponse.Loading -> {
            println("Loading...")
        }

        is ApiResponse.Success -> {
            println("Success: ${result.data}")
        }

        is ApiResponse.Failure -> {
            println("Error: ${result.errorMessage}")
        }
    }
}

fun handScreen(screen: Screen) {
    when(screen){
        is Screen.Home -> println("Chuyển đến Home")
        is Screen.Profile -> println("Profile")
        is Screen.Setting -> println("Setting")
        is Screen.Login -> println("Login")
    }
}

//Enum
fun enumDay(days: DAYS) {
    when (days) {
        DAYS.SUNDAY -> println("$days is a rest day")
        DAYS.MONDAY -> println("$days is a work day")
        DAYS.TUESDAY -> println("$days is a work day")
        DAYS.WEDNESDAY -> println("$days is a work day")
        DAYS.THURSDAY -> println("$days is a work day")
        DAYS.FRIDAY -> println("$days is a work day")
        DAYS.SATURDAY -> println("$days is a rest day")
    }
}

fun main() {
    //sealed class
    val success = ApiResponse.Success("Success")
    handleApiResponse(success)
    val error = ApiResponse.Failure("Error",123)
    handleApiResponse(error)
    val loading = ApiResponse.Loading
    handleApiResponse(loading)

    handScreen(Screen.Home)

    //enum
    val day = DAYS.SUNDAY
    enumDay(day)

    //dùng values trả về danh sách các giá trị của enum
    for (days in DAYS.entries) {
        println(days)
    }

    println(DAYS.isWeekday(day))
    println(DAYS.isWeekend(day))
    println(DAYS.getDay(2))

    val color = Cards.Diamond.color
    println("Color of Diamond = $color")
    val color2 = Cards.Heart.color
    println("Color of Heart = $color2")

    val summer = Weather.SUMMER
    println(summer.description())
    val winter = Weather.WINTER
    println(winter.description())

    val trafficLight =TrafficLight.Red
    println(trafficLight.description())
    val trafficLight2 =TrafficLight.Yellow
    println(trafficLight2.description())
    val trafficLight3 =TrafficLight.Green
    println(trafficLight3.seconds)


    //Generic
    val box = Box(6, 5)
    val box1 = Box(6.5, 5.7)
    val box2 = Box(6f, 5.5f)

    println(box.getValue())
    println(box1.getValue())
    println(box2.getValue())

    val repo = UserRepository()
    repo.add(User(1, "Tài"))
    repo.add(User(2, "An"))
    println("Tìm user id=2: ${repo.getId(2).name}")

    // Generic function
    printValue("Hello")
    printValue(123)

    // out example
    val outString: OutClass<String> = OutClass("Hello World")
    val outAny: OutClass<Any> = outString // Covariance cho phép
    println("Out Any: ${outAny.get()}")

    // in example
    val inNumber: InClass<Number> = InClass()
    val inInt: InClass<Int> = inNumber // Contravariance cho phép
    println("In Int: ${inInt.toString(42)}")

}





