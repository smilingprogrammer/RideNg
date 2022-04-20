package com.example.rideng.model.registerUser

data class NewUser(
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String,
    val bvn: String,
    val phone: String
)