package com.example.rideng.model.registerUser

import com.google.gson.annotations.SerializedName

data class Data(
//    @SerializedName("__v")
    val __v: Int,
//    @SerializedName("_id")
    val _id: String,
//    @SerializedName("confirmEmailToken")
    val confirmEmailToken: String,
//    @SerializedName("createdAt")
    val createdAt: String,
//    @SerializedName("driveManual")
    val driveManual: Boolean,
//    @SerializedName("email")
    val email: String,
//    @SerializedName("id")
    val id: String,
//    @SerializedName("isEmailConfirmed")
    val isEmailConfirmed: Boolean,
//    @SerializedName("name")
    val name: String,
//    @SerializedName("password")
    val password: String,
//    @SerializedName("role")
    val role: String,
//    @SerializedName("username")
    val username: String
)