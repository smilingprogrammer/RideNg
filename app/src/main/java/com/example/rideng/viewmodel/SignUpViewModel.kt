package com.example.rideng.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rideng.model.registerUser.NewUser
import com.example.rideng.model.registerUser.NewUserResponse
import com.example.rideng.network.ApiClient
import com.example.rideng.network.RideNgApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class SignUpViewModel : ViewModel() {

    lateinit var newUserLiveData: MutableLiveData<NewUserResponse>()

    init {
        newUserLiveData = MutableLiveData()
    }

    fun getNewUserObserver(): MutableLiveData<NewUserResponse>{
        return newUserLiveData
    }

    fun registerUser(newUser: NewUser){
        viewModelScope.launch {
            val retrofitService = ApiClient.getRetrofitInstance().create(RideNgApi::class.java)
            val call = retrofitService.registerUser(newUser)
            call.enqueue(object: Callback<NewUserResponse>{
                override fun onFailure(call: Call<NewUserResponse>, t: Throwable) {
                    newUserLiveData.postValue(null)
                }

                override fun onResponse(
                    call: Call<NewUserResponse>,
                    response: Response<NewUserResponse>
                ) {
                    if (response.isSuccessful){
                        newUserLiveData.postValue(response.body())
                    } else {
                        newUserLiveData.postValue(null)
                    }
                }
            })
        }
//        viewModelScope.launch {
//            try {
//                newUserResponse.value
//            } catch (e: Exception){
//
//            }
//        }
    }
}