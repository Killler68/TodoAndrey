package com.example.myapplication.hotels.hotellist.viewmodel

import com.example.myapplication.hotels.hotellist.model.HotelsAndDetailed

interface HotelsAndDetailedUseCase {

    suspend operator fun invoke(): List<HotelsAndDetailed>
}