package com.example.myapplication.hotels.hotellist.usecase

import com.example.myapplication.hotels.hotellist.viewmodel.HotelDetailedNavigatorUseCase
import com.example.myapplication.common.navigation.Screens
import com.github.terrakok.cicerone.Router

class HotelDetailedNavigatorUseCaseImpl(
    private val router: Router
) : HotelDetailedNavigatorUseCase {

    override fun invoke(id: Int) = router.navigateTo(Screens.toHotelDetailed(id))
}