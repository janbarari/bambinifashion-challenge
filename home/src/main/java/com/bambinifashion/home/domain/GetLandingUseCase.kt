package com.bambinifashion.home.domain

import com.bambinifashion.architecture.usecase.UseCaseNoInput

class GetLandingUseCase(
    private val repo: HomeRepository
) : UseCaseNoInput<LandingPage?>() {

    override suspend fun execute(): LandingPage? {
        return repo.getLanding()
    }

}
