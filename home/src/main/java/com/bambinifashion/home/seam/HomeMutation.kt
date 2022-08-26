package com.bambinifashion.home.seam

import com.bambinifashion.architecture.seam.Mutation
import com.bambinifashion.home.domain.LandingPage
import com.bambinifashion.home.domain.PromotionPage

sealed class HomeMutation(
    mutation: Mutation<HomeState>,
) : Mutation<HomeState> by mutation {

    object OnLoading : HomeMutation(
        {
            it.copy(
                isLoading = true,
                page = null,
                error = null,
                promotions = null
            )
        }
    )

    data class OnSuccess(
        val page: LandingPage,
        val promotions: PromotionPage
    ) : HomeMutation(
        {
            it.copy(
                page = page,
                promotions = promotions,
                isLoading = false,
                error = null
            )
        }
    )

    data class OnError(
        val exception: Throwable
    ) : HomeMutation(
        {
            it.copy(
                isLoading = false,
                error = exception,
                promotions = null,
                page = null
            )
        }
    )

}
