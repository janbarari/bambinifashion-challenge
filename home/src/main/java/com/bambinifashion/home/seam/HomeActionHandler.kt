package com.bambinifashion.home.seam

import com.bambinifashion.architecture.seam.ActionHandler
import com.bambinifashion.home.domain.GetLandingUseCase
import com.bambinifashion.home.domain.GetPromotionsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeActionHandler @Inject constructor(
    private val getLandingUseCase: GetLandingUseCase,
    private val getPromotionsUseCase: GetPromotionsUseCase
) : ActionHandler<HomeState, HomeEffect, HomeAction, HomeMutation> {
    override fun handleAction(
        state: HomeState,
        action: HomeAction,
        effect: suspend (HomeEffect) -> Unit
    ): Flow<HomeMutation> = when (action) {

        is HomeAction.LoadLanding -> flow {
            try {
                emit(HomeMutation.OnLoading)

                val landing = getLandingUseCase.execute()
                val promotions = getPromotionsUseCase.execute()

                if (landing != null && promotions != null) {
                    emit(
                        HomeMutation.OnSuccess(
                            landing,
                            promotions
                        )
                    )
                } else {
                    emit(HomeMutation.OnError(Throwable("Page is empty.")))
                }
            } catch (e: Throwable) {
                emit(
                    HomeMutation.OnError(e)
                )
            }
        }

    }
}