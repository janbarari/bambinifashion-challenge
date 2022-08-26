package com.bambinifashion.architecture.seam

import kotlinx.coroutines.flow.Flow

interface ActionHandler<S, E, A, M: Mutation<S>> {
    fun handleAction(state: S, action: A, effect: suspend (E) -> Unit): Flow<M>
}
