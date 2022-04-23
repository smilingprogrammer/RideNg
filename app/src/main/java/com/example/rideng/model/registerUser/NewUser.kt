package com.example.rideng.model.registerUser

import com.google.gson.annotations.SerializedName

data class NewUser(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)