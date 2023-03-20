package com.example.myapplication.featuresscreen.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.featuresscreen.viewmodel.SettingsNavigatorUseCase
import com.github.terrakok.cicerone.Router

class SettingsNavigatorUseCaseImpl(
    private val router: Router
) : SettingsNavigatorUseCase {
    override fun invoke(userId: Int) = router.navigateTo(Screens.toSettings(userId))
}