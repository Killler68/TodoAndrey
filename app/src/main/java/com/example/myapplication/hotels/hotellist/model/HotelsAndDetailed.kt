package com.example.myapplication.hotels.hotellist.model

data class HotelsAndDetailed(
    val id: Int,
    val name: String,
    val address: String,
    val stars: Double,
    val distance: Double,
    val image: String?,
    val suitesAvailability: String
)