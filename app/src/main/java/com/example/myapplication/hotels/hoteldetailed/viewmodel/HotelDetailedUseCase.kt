package com.example.myapplication.hotels.hoteldetailed.viewmodel

import com.example.myapplication.hotels.hoteldetailed.model.HotelDetailed

interface HotelDetailedUseCase {

    suspend operator fun invoke(id: Int): HotelDetailed
}