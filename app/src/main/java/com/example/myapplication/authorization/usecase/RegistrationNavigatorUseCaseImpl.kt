package com.example.myapplication.authorization.usecase

import com.example.myapplication.authorization.viewmodel.RegistrationNavigatorUseCase
import com.example.myapplication.common.navigation.Screens
import com.github.terrakok.cicerone.Router

class RegistrationNavigatorUseCaseImpl(
    private val router: Router
) : RegistrationNavigatorUseCase {

    override fun invoke() = router.navigateTo(Screens.toRegistration())
}