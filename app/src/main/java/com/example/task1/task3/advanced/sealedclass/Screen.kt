package com.example.task1.task3.advanced.sealedclass

//Trong Android sealed class thường được sử dụng cho Compose/Navigation
sealed class Screen(val route:String){
    data object Home :Screen("home")
    data object Profile:Screen("profile")
    data object Setting:Screen("setting")
    data object Login:Screen("login")

}