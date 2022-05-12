package com.example.rideng.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.loginuser.LoginInfo
import com.example.rideng.model.loginuser.LoginResponse
import com.example.rideng.repository.AuthRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class SignInViewModel : ViewModel() {

    private val authRepository = AuthRepository()
    private val TAG = SignInViewModel::class.java.simpleName

    var user: MutableLiveData<Response<LoginResponse>> = MutableLiveData()

    fun loginUser(loginInfo: LoginInfo){
        viewModelScope.launch {
            val response = authRepository.loginUser(loginInfo)
            user.value = response
            Log.d(TAG, "${user.value}")
        }
    }

}