package com.example.rideng.model.registerUser

import com.google.gson.annotations.SerializedName

data class NewUserResponse(
//    @SerializedName("data")
    val `data`: Data,
//    @SerializedName("success")
    val success: Boolean,
//    @SerializedName("token")
    val token: String
)