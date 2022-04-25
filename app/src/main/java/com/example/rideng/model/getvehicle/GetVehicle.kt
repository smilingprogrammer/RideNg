package com.example.rideng.model.getvehicle

data class GetVehicle(
    val count: Int,
    val `data`: List<Data>,
    val pagination: Pagination,
    val success: Boolean
)