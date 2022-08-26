package com.bambinifashion.network

import com.bambinifashion.datastore.UserDataStore
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "BASE_URL"

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()

    }

    @Provides
    @Named(BASE_URL)
    fun provideNetworkBaseUrl(): String {
        return "https://babydriver-android.bambinimirror.com/m/v1/"
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideAuthenticationInterceptor(userDataStore: UserDataStore): Interceptor {
        return Interceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .header("bf-api-key", userDataStore.get().apiKey)
                .header("bf-localization", userDataStore.get().localization)
                .build()
            chain.proceed(newRequest)
        }
    }

    @Provides
    fun provideRetrofit(
        @Named(BASE_URL) baseUrl: String,
        authenticationInterceptor: Interceptor,
        loggingInterceptor: HttpLoggingInterceptor,
        moshi: Moshi
    ): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(authenticationInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .client(client)
            .build()
    }

}
