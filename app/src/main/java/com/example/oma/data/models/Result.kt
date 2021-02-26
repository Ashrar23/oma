package com.example.oma.data.models

sealed class Result {
    object Loading : Result()
    class Success<T>(val data: T) : Result()
    class Error(val error: Throwable) : Result()
}