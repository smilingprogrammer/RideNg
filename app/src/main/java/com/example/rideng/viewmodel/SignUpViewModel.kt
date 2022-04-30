package com.example.rideng.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.repository.AuthRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class SignUpViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val TAG = "RETROFIT_ERROR"

    var newUserResponse: MutableLiveData<Response<NewUserResponse>> = MutableLiveData()

    fun registerUser(newUser: NewUser){
        viewModelScope.launch {
            val response = authRepository.registerUser(newUser)
            newUserResponse.value = response
        }
    }
}