package com.example.myapplication.hotels.hotellist.usecase

import com.example.myapplication.hotels.hoteldetailed.usecase.HotelDetailedRepository
import com.example.myapplication.hotels.hotellist.model.HotelsAndDetailed
import com.example.myapplication.hotels.hotellist.viewmodel.HotelsAndDetailedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HotelsAndDetailedUseCaseImpl(
    private val hotelListRepository: HotelListRepository,
    private val hotelDetailedRepository: HotelDetailedRepository
) : HotelsAndDetailedUseCase {

    override suspend fun invoke(): List<HotelsAndDetailed> = withContext(Dispatchers.Default) {

        val hotels = hotelListRepository()

        val hotelsAndDetailed = hotels.map {
            val detailed = hotelDetailedRepository(it.id)
            HotelsAndDetailed(
                it.id,
                it.name,
                it.address,
                it.stars,
                it.distance,
                detailed.image,
                it.suitesAvailability
            )
        }
        hotelsAndDetailed
    }
}