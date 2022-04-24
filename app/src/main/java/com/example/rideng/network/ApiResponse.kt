package com.example.rideng.network

import com.squareup.moshi.Json

data class ApiResponse(

    @Json(name = "status_message")
    val errorMessage: String?,

    @Json(name = "status_code")
    val errorCode: Int?

)
