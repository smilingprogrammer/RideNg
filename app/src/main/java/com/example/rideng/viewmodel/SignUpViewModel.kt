package com.example.rideng.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.network.RideNgApi
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    val newUserResponse = MutableLiveData<NewUserResponse>()
    var apiError = MutableLiveData<String>()


    fun registerUser(newUser: NewUser){
        viewModelScope.launch {
            var registration = RideNgApi.registerUser(newUser)

            try {
                if (registration.isSuccessful){

                }
            } catch (e: Exception){

            }
        }
    }
}