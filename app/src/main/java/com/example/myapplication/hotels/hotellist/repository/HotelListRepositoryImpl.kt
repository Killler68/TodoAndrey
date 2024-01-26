package com.example.myapplication.hotels.hotellist.repository

import com.example.myapplication.hotels.remote.api.HotelsApi
import com.example.myapplication.hotels.hotellist.model.Hotels
import com.example.myapplication.hotels.hotellist.model.toHotelList
import com.example.myapplication.hotels.hotellist.usecase.HotelListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HotelListRepositoryImpl(
    private val hotelsApi: HotelsApi
) : HotelListRepository {

    override suspend operator fun invoke(): List<Hotels> = withContext(Dispatchers.IO) {
        val response = hotelsApi.getHotelsList()
        response.map { it.toHotelList() }
    }
}

