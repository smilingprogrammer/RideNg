package com.example.rideng.model.getvehicle

data class Location(
    val city: String,
    val coordinates: List<Double>,
    val country: String,
    val countryCode: String,
    val formattedAddress: String,
    val state: String,
    val street: String,
    val type: String,
    val zipcode: String
)