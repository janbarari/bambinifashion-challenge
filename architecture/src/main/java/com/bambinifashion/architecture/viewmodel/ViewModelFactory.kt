package com.bambinifashion.architecture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Lazy
import javax.inject.Inject

@Suppress("unchecked_cast")
class ViewModelFactory<T: ViewModel> @Inject constructor(private val viewModel: Lazy<T>): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModel.get() as T
    }
}