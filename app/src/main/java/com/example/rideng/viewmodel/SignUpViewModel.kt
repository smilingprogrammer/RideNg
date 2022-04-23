package com.example.rideng.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.network.RideNgApi
import com.example.rideng.repository.SignUpRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.http.POST
import java.net.SocketTimeoutException

class SignUpViewModel(private val signUpRepository: SignUpRepository) : ViewModel() {

    private val TAG = "RETROFIT_ERROR"

    var newUserResponse = MutableLiveData<Call<NewUserResponse>>()

    fun registerUser(newUser: NewUser){
        try {

            viewModelScope.launch {
                val response = signUpRepository.registerUser(newUser)
                newUserResponse.value = response
            }
        } catch (e: HttpException){
            Log.d(TAG, e.message())
        }
    }
}