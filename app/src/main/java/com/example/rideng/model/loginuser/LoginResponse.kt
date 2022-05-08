package com.example.rideng.model.loginuser

data class LoginResponse(
    val loginData: LoginData,
    val success: Boolean,
    val token: String
)