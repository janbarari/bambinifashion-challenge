package com.bambinifashion.home.domain

import com.bambinifashion.architecture.usecase.UseCaseNoInput

class GetPromotionsUseCase(
    private val repo: HomeRepository
) : UseCaseNoInput<PromotionPage?>() {

    override suspend fun execute(): PromotionPage? {
        return repo.getPromotions()
    }

}
