package com.example.rideng.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://ride-ng.herokuapp.com/api/"
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()

private fun httpClient(): OkHttpClient {

    val interceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    return OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
    }.build()
}

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(httpClient())
    .build()

object ApiClient {
    val retrofitService: RideNgApi by lazy {
        retrofit.create(RideNgApi::class.java)
    }
}