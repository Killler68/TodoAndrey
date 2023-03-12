package com.example.myapplication.registration.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.registration.viewmodel.AuthorizationNavigatorUseCase
import com.github.terrakok.cicerone.Router

class AuthorizationNavigatorUseCaseImpl(
    private val router: Router
) : AuthorizationNavigatorUseCase {

    override fun invoke() = router.navigateTo(Screens.toAuthorization())
}