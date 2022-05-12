package com.example.rideng.network

import com.example.rideng.model.getvehicle.GetVehicle
import com.example.rideng.model.loginuser.LoginInfo
import com.example.rideng.model.loginuser.LoginResponse
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import retrofit2.Response
import retrofit2.http.*

interface RideNgApi {

    //Register User
    @POST("/api/v1/auth/register")
    @Headers("Content-Type: application/json")
    suspend fun registerUser(@Body newUser: NewUser): Response<NewUserResponse>

    //LoginUser
    @POST("/api/v1/auth/login")
    suspend fun loginUser(@Body loginInfo: LoginInfo): Response<LoginResponse>

    @GET("/api/v1/vehicles")
    suspend fun getVehicle(): GetVehicle

}