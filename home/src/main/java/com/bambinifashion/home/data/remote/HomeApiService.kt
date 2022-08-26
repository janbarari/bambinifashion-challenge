package com.bambinifashion.home.data.remote

import com.bambinifashion.home.domain.LandingPage
import com.bambinifashion.home.domain.PromotionPage
import retrofit2.http.GET

interface HomeApiService {

    @GET("./page:type=landing")
    suspend fun getLanding(): LandingPage

    @GET("./user:proline")
    suspend fun getPromotions(): PromotionPage

}

