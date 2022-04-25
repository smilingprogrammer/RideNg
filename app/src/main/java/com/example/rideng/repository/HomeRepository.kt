package com.example.rideng.repository

import com.example.rideng.model.getvehicle.GetVehicle
import com.example.rideng.network.ApiClient
import com.example.rideng.network.RideNgApi

class HomeRepository() {

    private val apiService = ApiClient.retrofitService

    suspend fun getVehicle(): GetVehicle {
        return apiService.getVehicle()
    }

}