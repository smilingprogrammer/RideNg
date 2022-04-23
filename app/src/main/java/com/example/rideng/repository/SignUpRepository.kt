package com.example.rideng.repository

import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.network.ApiClient
import com.example.rideng.network.RideNgApi
import retrofit2.Call
import retrofit2.Response

class SignUpRepository(private val rideNgApi: RideNgApi) {

    private val apiSerVice = ApiClient.retrofitService

    suspend fun registerUser(newUser: NewUser): Call<NewUserResponse> {
        return rideNgApi.registerUser(newUser)
    }
}