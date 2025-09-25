package com.example.task1.task3.advanced.sealedclass

//Api Responses
sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Failure(val errorMessage: String,val errorCode: Int) : ApiResponse<Nothing>()
    data object Loading : ApiResponse<Nothing>()
}