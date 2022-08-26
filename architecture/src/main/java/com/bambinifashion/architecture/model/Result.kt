package com.bambinifashion.architecture.model

sealed class Result {
    data class Loading(val isLoading: Boolean): Result()
    data class Error(val error: Throwable): Result()
    data class Success<T>(val result: T): Result()
}
