package com.example.rideng.network

import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RideNgApi {

    //Register User
    @POST("v1/auth/register")
    suspend fun registerUser(@Body newUser: NewUser): Call<NewUserResponse>
}