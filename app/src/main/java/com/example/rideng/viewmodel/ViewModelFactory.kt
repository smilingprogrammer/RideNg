package com.example.rideng.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rideng.repository.SignUpRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val signUpRepository: SignUpRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)){
            return SignUpViewModel(signUpRepository) as T
        } else{
            throw IllegalArgumentException("UNKNOWN")
        }
    }
}