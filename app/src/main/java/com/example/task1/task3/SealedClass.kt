package com.example.task1.task3

//Sealed class:
sealed class NetworkResult {
    data class Success (val data: String) : NetworkResult()
    data class Error(val errorMessage: String) : NetworkResult()
    object Loading :NetworkResult()
}

//Trong Android sealed class thường được sử dụng để biểu diễn các trạng thái khác nhau của UI
sealed class UiState{
    object Loading : UiState()
    data class Success(val data: String) : UiState()
    data class Error(val errorMessage: String) : UiState()

}

//Api Responses
sealed class ApiResponse {
    data class Success<T>(val data: T) : ApiResponse()
    data class Failure(val errorMessage: String,val errorCode: Int) : ApiResponse()
    object Loading : ApiResponse()
}