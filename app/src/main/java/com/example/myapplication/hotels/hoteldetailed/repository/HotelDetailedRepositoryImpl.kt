package com.example.myapplication.hotels.hoteldetailed.repository

import com.example.myapplication.hotels.remote.api.HotelsApi
import com.example.myapplication.hotels.hoteldetailed.model.HotelDetailed
import com.example.myapplication.hotels.hoteldetailed.model.toHotelDetailed
import com.example.myapplication.hotels.hoteldetailed.usecase.HotelDetailedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HotelDetailedRepositoryImpl(
    private val hotelsApi: HotelsApi
) : HotelDetailedRepository {

    override suspend operator fun invoke(id: Int): HotelDetailed = withContext(Dispatchers.IO) {
        val response = hotelsApi.getHotelDetailed(id)
        response.toHotelDetailed()
    }
}