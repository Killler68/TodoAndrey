package com.example.myapplication.hotels.hoteldetailed.usecase

import com.example.myapplication.hotels.hoteldetailed.viewmodel.BackNavigatorUseCase
import com.github.terrakok.cicerone.Router

class BackNavigatorUseCaseImpl(
    private val router: Router
) : BackNavigatorUseCase {

    override fun invoke() = router.exit()
}