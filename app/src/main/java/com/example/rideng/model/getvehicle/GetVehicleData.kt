package com.example.rideng.model.getvehicle

import java.io.Serializable

data class GetVehicleData(
    val __v: Int,
    val _id: String,
    val averageRating: Double,
    val book_date: String,
    val booking_id: String,
    val category: String,
    val cost: Int,
    val description: String,
    val distance: Int,
    val doors: Int,
    val features: List<String>,
    val freecancelation: Boolean,
    val fuel_type: String,
    val images: List<String>,
    val isBooked: Boolean,
    val isVerified: Boolean,
    val location: Location,
    val make: String,
    val model: String,
    val seats: Int,
    val transmission: String,
    val user: User,
    val volume: String,
    val year: Int
): Serializable