package com.mobbelldev.netflixclone.data.di

import com.mobbelldev.netflixclone.BuildConfig
import com.mobbelldev.netflixclone.data.source.network.ApiService
import com.mobbelldev.netflixclone.data.source.network.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = BuildConfig.API_KEY_AUTH
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                when (BuildConfig.DEBUG) {
                    true -> HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                    false -> HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
                }
            )
            .addInterceptor(AuthorizationInterceptor(API_KEY))
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}