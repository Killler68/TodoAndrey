package com.example.myapplication.common.usecase

import com.example.myapplication.common.navigation.Screens
import com.github.terrakok.cicerone.Router

class AuthorizationNavigatorUseCaseImpl(
    private val router: Router
) : AuthorizationNavigatorUseCase {

    override fun invoke() = router.navigateTo(Screens.toAuthorization())
}