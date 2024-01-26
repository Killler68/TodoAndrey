package com.example.myapplication.hotels.hotellist.model

import com.example.myapplication.hotels.remote.api.dto.HotelsResponse

data class Hotels(
    val id: Int,
    val name: String,
    val address: String,
    val stars: Double,
    val distance: Double,
    val suitesAvailability: String
)

fun HotelsResponse.toHotelList(): Hotels {
    return Hotels(
        id,
        name,
        address,
        stars,
        distance,
        suites_availability
    )
}