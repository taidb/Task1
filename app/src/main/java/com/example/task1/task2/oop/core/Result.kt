package com.example.task1.task2.oop.core

// Sealed class: thường ứng dụng để quản lý trạng thái (Loading, Success, Error) trong API hoặc UI
sealed class SealedResult<out T> {
    object Loading : SealedResult<Nothing>()
    data class Success<T>(val data: T) : SealedResult<T>()
    data class Error(val error: String, var callError: Exception? = null) : SealedResult<Nothing>()
}