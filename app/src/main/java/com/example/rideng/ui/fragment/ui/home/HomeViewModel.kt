package com.example.rideng.ui.fragment.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.getvehicle.Data
import com.example.rideng.network.RideNgApi
import com.example.rideng.repository.HomeRepository
import com.example.rideng.repository.SignUpRepository
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel() {

    private val homeRepository = HomeRepository()

    private val TAG = HomeViewModel::class.java.simpleName
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text

    init {
        getVehicle()
    }

    private val _getVehicleLiveData = MutableLiveData<List<Data>>()
    val getVehicleLiveData: LiveData<List<Data>>
    get() = _getVehicleLiveData

    private fun getVehicle(){
        viewModelScope.launch {
            val getVehicleResponse = homeRepository.getVehicle().data
            _getVehicleLiveData.value = getVehicleResponse
            Log.d(TAG, "${_getVehicleLiveData.value}")
        }
    }
}