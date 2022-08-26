package com.bambinifashion.architecture.seam

fun interface Mutation<S> {
    fun reduce(state: S): S
}