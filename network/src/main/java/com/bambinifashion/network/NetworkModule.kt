package com.bambinifashion.network

import com.bambinifashion.datastore.UserDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "BASE_URL"

    @Provides
    @Named(BASE_URL)
    fun provideNetworkBaseUrl(): String {
        return "https://babydriver-android.bambinimirror.com/m/v1/"
    }

    @Provides
    fun provideAuthenticationInterceptor(userDataStore: UserDataStore): Interceptor {
        return Interceptor {
            val request = it.request()
            userDataStore.get()?.let {
                request.headers().newBuilder().apply {
                    add("bf-api-key", it.apiKey)
                    add("bf-localization", it.localization)
                }
            }
            it.proceed(request)
        }
    }

    @Provides
    fun provideRetrofit(
        @Named(BASE_URL) baseUrl: String,
        authenticationInterceptor: Interceptor
    ): Retrofit {
        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(authenticationInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }

}
