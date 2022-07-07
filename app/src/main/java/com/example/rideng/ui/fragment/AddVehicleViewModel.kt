package com.example.rideng.ui.fragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.addvehicle.AddVehicle
import com.example.rideng.model.addvehicle.AddVehicleResponse
import com.example.rideng.repository.HomeRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AddVehicleViewModel : ViewModel() {

    private val homeRepository = HomeRepository()

    private val TAG = AddVehicleViewModel::class.java.simpleName

    private val addVehicleResponse: MutableLiveData<Response<AddVehicleResponse>> = MutableLiveData()

    private fun addVehicle(addVehicle: AddVehicle){
        viewModelScope.launch {
            val addVehicleData = homeRepository.addVehicle(addVehicle)
            addVehicleResponse.value = addVehicleData
            Log.d(TAG, "${addVehicleResponse.value}")
        }
    }
}