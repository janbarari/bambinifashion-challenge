package com.bambinifashion.architecture.viewmodel

import androidx.lifecycle.ViewModel
import com.bambinifashion.architecture.seam.ActionHandler
import com.bambinifashion.architecture.seam.Mutation
import com.bambinifashion.architecture.seam.Seam
import com.bambinifashion.architecture.seam.SeamViaHandler.Companion.handler

abstract class BaseViewModel<S: Any, E: Any, A: Any, M: Mutation<S>>(
    private val actionHandler: ActionHandler<S, E, A, M>,
    private val initialState: S
): ViewModel(), Seam<S, E, A, M> by handler(
        actionHandler,
        initialState
    )
