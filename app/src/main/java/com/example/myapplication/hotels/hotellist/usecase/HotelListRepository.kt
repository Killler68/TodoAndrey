package com.example.myapplication.hotels.hotellist.usecase

import com.example.myapplication.hotels.hotellist.model.Hotels

interface HotelListRepository {

   suspend operator fun invoke(): List<Hotels>
}