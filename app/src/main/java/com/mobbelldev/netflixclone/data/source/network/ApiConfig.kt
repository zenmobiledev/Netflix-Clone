package com.mobbelldev.netflixclone.data.source.network

import android.content.Context
import com.mobbelldev.netflixclone.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig(private val context: Context) {
    private val okhttp = OkHttpClient.Builder()
        .addInterceptor(
            when (BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                false -> HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            }
        )
        .addInterceptor(AuthorizationInterceptor(API_KEY))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okhttp)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private const val API_KEY = BuildConfig.API_KEY_AUTH
    }
}