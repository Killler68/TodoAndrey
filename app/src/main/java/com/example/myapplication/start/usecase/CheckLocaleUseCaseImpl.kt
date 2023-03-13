package com.example.myapplication.start.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.common.sharedpreferences.LocalStorage
import com.example.myapplication.start.viewmodel.CheckLocaleUseCase
import com.github.terrakok.cicerone.Router

class CheckLocaleUseCaseImpl(
    private val localStorage: LocalStorage,
    private val router: Router
) : CheckLocaleUseCase {

    override suspend fun invoke() =
        if (localStorage.isFirstLaunch()) {
            router.navigateTo(Screens.toWelcome())
            localStorage.setFirstLaunch()
        } else router.navigateTo(Screens.toAuthorization())
}
