package com.bambinifashion.home.domain

interface HomeRepository {
    suspend fun getLanding(): LandingPage?
    suspend fun getPromotions(): PromotionPage?
}
