package com.example.task1.task3.advanced.sealedclass

//Sự dụng để trangj thái tải dữ liệu
sealed class DataState<out T> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val message: String) : DataState<Nothing>()
    data object Loading : DataState<Nothing>()
}