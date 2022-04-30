package com.example.rideng.repository

import com.example.rideng.model.getvehicle.GetVehicle
import com.example.rideng.model.loginuser.LoginResponse
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.network.ApiClient
import com.example.rideng.network.RideNgApi
import retrofit2.Response

class AuthRepository(private val rideNgApi: RideNgApi) {

    private val apiSerVice = ApiClient.retrofitService

    suspend fun registerUser(newUser: NewUser): Response<NewUserResponse> {
        return rideNgApi.registerUser(newUser)
    }

    suspend fun loginUser(username: String, password: String): Response<LoginResponse>{
        val params = HashMap<String?, String?>()
        params["email"] = username
        params["password"] = password

        return rideNgApi.loginUser(params)
    }
}