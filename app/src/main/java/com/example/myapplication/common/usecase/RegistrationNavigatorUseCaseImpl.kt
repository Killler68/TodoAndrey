package com.example.myapplication.common.usecase

import com.example.myapplication.common.usecase.RegistrationNavigatorUseCase
import com.example.myapplication.common.navigation.Screens
import com.github.terrakok.cicerone.Router

class RegistrationNavigatorUseCaseImpl(
    private val router: Router
) : RegistrationNavigatorUseCase {

    override fun invoke() = router.navigateTo(Screens.toRegistration())
}