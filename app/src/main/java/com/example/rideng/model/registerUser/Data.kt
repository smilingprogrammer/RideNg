package com.example.rideng.model.registerUser

data class Data(
    val bvn: String,
    val confirmEmailToken: String,
    val createdAt: String,
    val email: String,
    val firstname: String,
    val isEmailConfirmed: Boolean,
    val lastname: String,
    val password: String,
    val phone: String,
    val updatedAt: String,
    val user_id: Int
)