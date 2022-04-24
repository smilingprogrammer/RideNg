package com.example.rideng.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.repository.SignUpRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class SignUpViewModel(private val signUpRepository: SignUpRepository) : ViewModel() {

    private val TAG = "RETROFIT_ERROR"

    var newUserResponse: MutableLiveData<Response<NewUserResponse>> = MutableLiveData()

    fun registerUser(newUser: NewUser){
        viewModelScope.launch {
            val response = signUpRepository.registerUser(newUser)
            newUserResponse.value = response
        }
    }
}