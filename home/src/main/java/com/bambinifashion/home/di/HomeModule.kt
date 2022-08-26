package com.bambinifashion.home.di

import com.bambinifashion.database.AppDatabase
import com.bambinifashion.home.data.HomeRepositoryImpl
import com.bambinifashion.home.data.remote.HomeApiService
import com.bambinifashion.home.domain.HomeRepository
import com.bambinifashion.home.domain.GetLandingUseCase
import com.bambinifashion.home.domain.GetPromotionsUseCase
import com.bambinifashion.home.seam.HomeActionHandler
import com.bambinifashion.home.view.HomeViewModel
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import retrofit2.Retrofit

@Module
@InstallIn(FragmentComponent::class)
object HomeModule {

    @Provides
    fun provideHomeApiService(retrofit: Retrofit): HomeApiService {
        return retrofit.create(HomeApiService::class.java)
    }

    @Provides
    fun provideHomeRepository(api: HomeApiService, db: AppDatabase, moshi: Moshi): HomeRepository {
        return HomeRepositoryImpl(api, db, moshi)
    }

    @Provides
    fun provideGetLandingUseCase(repo: HomeRepository): GetLandingUseCase {
        return GetLandingUseCase(repo)
    }

    @Provides
    fun provideGetPromotionsUseCase(repo: HomeRepository): GetPromotionsUseCase {
        return GetPromotionsUseCase(repo)
    }

    @Provides
    fun provideHomeActionHandler(getLandingUseCase: GetLandingUseCase, getPromotionsUseCase: GetPromotionsUseCase): HomeActionHandler {
        return HomeActionHandler(getLandingUseCase, getPromotionsUseCase)
    }

    @Provides
    fun provideHomeViewModel(homeActionHandler: HomeActionHandler): HomeViewModel {
        return HomeViewModel(homeActionHandler)
    }

}
