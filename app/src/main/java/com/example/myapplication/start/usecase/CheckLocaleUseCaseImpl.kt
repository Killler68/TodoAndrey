package com.example.myapplication.start.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.common.sharedpreferences.LocalStorage
import com.example.myapplication.start.viewmodel.CheckLocaleUseCase
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CheckLocaleUseCaseImpl(
    private val router: Router,
    private val localStorage: LocalStorage
) : CheckLocaleUseCase {

    override suspend fun invoke() = withContext(Dispatchers.IO) {
        if (localStorage.isFirstLaunch()) {
            router.navigateTo(Screens.toWelcome)
            localStorage.setFirstLaunch()
        } else router.navigateTo(Screens.toAuthorization())
    }
}