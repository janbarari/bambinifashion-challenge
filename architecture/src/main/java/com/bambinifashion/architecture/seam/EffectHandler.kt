package com.bambinifashion.architecture.seam

interface EffectHandler<E> {
    suspend fun handleEffect(effect: E)
}
