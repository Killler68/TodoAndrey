package com.example.myapplication.hotels.remote.api.dto

import com.google.gson.annotations.SerializedName

data class HotelDetailedResponse(
    val id: Int,
    val name: String,
    val address: String,
    val stars: Double,
    val distance: Double,
    val image: String,
    @SerializedName("suites_availability") val suitesAvailability: String,
    val lat: Double,
    val lon: Double
)