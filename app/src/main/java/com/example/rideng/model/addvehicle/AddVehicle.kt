package com.example.rideng.model.addvehicle

data class AddVehicle(
    val address: String,
    val category: String,
    val cost: Int,
    val description: String,
    val doors: Int,
    val features: List<String>,
    val fuel_type: String,
    val make: String,
    val model: String,
    val seats: Int,
    val transmission: String,
    val volume: String,
    val year: Int
)