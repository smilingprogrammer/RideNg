package com.example.rideng.repository

import com.example.rideng.model.loginuser.LoginInfo
import com.example.rideng.model.loginuser.LoginResponse
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.network.ApiClient
import com.example.rideng.network.RideNgApi
import retrofit2.Response

class AuthRepository {

    private val apiSerVice = ApiClient.retrofitService

    suspend fun registerUser(newUser: NewUser): Response<NewUserResponse> {
        return apiSerVice.registerUser(newUser)
    }

    suspend fun loginUser(loginInfo: LoginInfo): Response<LoginResponse>{
        return apiSerVice.loginUser(loginInfo)
    }
}