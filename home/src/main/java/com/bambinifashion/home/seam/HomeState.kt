package com.bambinifashion.home.seam

import com.bambinifashion.home.domain.LandingPage
import com.bambinifashion.home.domain.PromotionPage

data class HomeState(
    val isLoading: Boolean = false,
    val page: LandingPage? = null,
    val promotions: PromotionPage? = null,
    val error: Throwable? = null
)
