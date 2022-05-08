package com.example.rideng.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.repository.AuthRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class SignUpViewModel : ViewModel() {

    private val authRepository = AuthRepository()
    private val TAG = SignUpViewModel::class.java.simpleName

    var newUserResponse: MutableLiveData<Response<NewUserResponse>> = MutableLiveData()

    fun registerUser(newUser: NewUser){
        viewModelScope.launch {
            val response = authRepository.registerUser(newUser)
            newUserResponse.value = response
            Log.d(TAG, "${newUserResponse.value}")
        }
    }
}