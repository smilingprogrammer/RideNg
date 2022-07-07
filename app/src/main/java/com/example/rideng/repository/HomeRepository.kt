package com.example.rideng.repository

import com.example.rideng.model.addvehicle.AddVehicle
import com.example.rideng.model.addvehicle.AddVehicleResponse
import com.example.rideng.model.getvehicle.GetVehicle
import com.example.rideng.network.ApiClient
import com.example.rideng.network.RideNgApi
import retrofit2.Response

class HomeRepository() {

    private val apiService = ApiClient.retrofitService

    suspend fun getVehicle(): GetVehicle {
        return apiService.getVehicle()
    }

    suspend fun addVehicle(addVehicle: AddVehicle): Response<AddVehicleResponse> {
        return apiService.addVehicle(addVehicle)
    }

}