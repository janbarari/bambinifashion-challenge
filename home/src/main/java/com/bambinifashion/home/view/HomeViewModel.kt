package com.bambinifashion.home.view

import androidx.lifecycle.viewModelScope
import com.bambinifashion.architecture.viewmodel.BaseViewModel
import com.bambinifashion.home.seam.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    homeActionHandler: HomeActionHandler
): BaseViewModel<HomeState, HomeEffect, HomeAction, HomeMutation>(
    homeActionHandler,
    HomeState()
) {

    init {
        loadBreeds()
    }

    private fun loadBreeds() {
        viewModelScope.launch {
            action(HomeAction.LoadLanding)
        }
    }

}
