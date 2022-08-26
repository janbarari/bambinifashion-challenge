package com.bambinifashion.architecture.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

abstract class UseCaseNoInput<O>(protected val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO) {
    abstract suspend fun execute(): O
}
