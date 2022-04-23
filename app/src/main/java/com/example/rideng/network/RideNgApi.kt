package com.example.rideng.network

import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface RideNgApi {


    //Register User
    @POST("api/v1/auth/register")
    @Headers("Content-Type: application/json")
    suspend fun registerUser(@Body newUser: NewUser): Call<NewUserResponse>

//    companion object {
//        operator fun invoke(): RideNgApi {
//
//            val builder = OkHttpClient.Builder()
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS)
//            val client = builder.build()
//
//            return Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(baseUrl)
//                .client(client)
//                .build()
//                .create(RideNgApi::class.java)
//        }
//    }
}