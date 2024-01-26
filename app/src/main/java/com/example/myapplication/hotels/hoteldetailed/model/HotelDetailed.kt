package com.example.myapplication.hotels.hoteldetailed.model

import com.example.myapplication.hotels.remote.api.dto.HotelDetailedResponse

data class HotelDetailed(
    val id: Int,
    val name: String,
    val address: String,
    val stars: Double,
    val distance: Double,
    val image: String?,
    val suitesAvailability: String
)

fun HotelDetailedResponse.toHotelDetailed(): HotelDetailed {
    return HotelDetailed(
        id,
        name,
        address,
        stars,
        distance,
        image,
        suitesAvailability
    )
}
