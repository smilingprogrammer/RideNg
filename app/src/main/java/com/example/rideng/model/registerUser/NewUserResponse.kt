package com.example.rideng.model.registerUser

data class NewUserResponse(
//    @SerializedName("data")
    val `data`: RegisterUserData,
//    @SerializedName("success")
    val success: Boolean,
//    @SerializedName("token")
    val token: String
)