package com.bambinifashion.architecture.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

abstract class UseCase<I, O>(protected val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO) {
    abstract suspend fun execute(input: I): O
}
