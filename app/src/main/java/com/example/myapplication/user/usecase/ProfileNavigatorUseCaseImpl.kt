package com.example.myapplication.user.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.user.viewmodel.ProfileNavigatorUseCase
import com.github.terrakok.cicerone.Router

class ProfileNavigatorUseCaseImpl(
    private val router: Router
) : ProfileNavigatorUseCase {

    override fun invoke(userId: Int) = router.navigateTo(Screens.toProfile(userId))
}