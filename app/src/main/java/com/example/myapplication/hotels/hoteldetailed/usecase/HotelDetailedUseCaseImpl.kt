package com.example.myapplication.hotels.hoteldetailed.usecase

import com.example.myapplication.hotels.hoteldetailed.model.HotelDetailed
import com.example.myapplication.hotels.hoteldetailed.viewmodel.HotelDetailedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HotelDetailedUseCaseImpl(
    private val repository: HotelDetailedRepository
) : HotelDetailedUseCase {

    override suspend fun invoke(id: Int): HotelDetailed = withContext(Dispatchers.Default) {
        repository(id)
    }
}