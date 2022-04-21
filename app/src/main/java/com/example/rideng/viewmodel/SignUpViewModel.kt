package com.example.rideng.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.network.RideNgApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.SocketTimeoutException

class SignUpViewModel : ViewModel() {

    private val TAG = "RETROFIT_ERROR"

    var newUserResponse = MutableLiveData<NewUserResponse>()
    var error = MutableLiveData<String>()
    var new = MutableLiveData<NewUserResponse>()

    fun registerUser(newUser: NewUser){
        viewModelScope.launch {
            var registration = RideNgApi().register(newUser)
            try {
                if (registration.isSuccessful){
                    new.value = registration.body()
                    Log.d(TAG, "${registration.body()}")
                } else {
                    error.value = registration.message()
                    Log.d(TAG, "$registration")
                }
            } catch (e: Exception) {
                Log.d(TAG, "${e.message}")
            } catch (e: SocketTimeoutException) {
                Log.d(TAG, "${e.message}")
            }
        }
    }
}