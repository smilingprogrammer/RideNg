package com.example.rideng.model.registerUser

data class NewUserResponse(
    val data: Data,
    val success: Boolean,
    val token: String
)