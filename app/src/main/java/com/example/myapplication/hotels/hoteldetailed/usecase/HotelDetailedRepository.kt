package com.example.myapplication.hotels.hoteldetailed.usecase

import com.example.myapplication.hotels.hoteldetailed.model.HotelDetailed

interface HotelDetailedRepository {

    suspend operator fun invoke(id: Int): HotelDetailed
}