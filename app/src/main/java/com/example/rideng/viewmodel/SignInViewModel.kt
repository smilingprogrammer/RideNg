package com.example.rideng.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.loginuser.LoginResponse
import com.example.rideng.network.RideNgApi
import com.example.rideng.repository.AuthRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class SignInViewModel(private val authRepository: AuthRepository) : ViewModel() {

    var user: MutableLiveData<Response<LoginResponse>> = MutableLiveData()

    fun loginUser(username: String, password: String){
        viewModelScope.launch {
            val response = authRepository.loginUser(username, password)
            user.value = response
        }
    }

}