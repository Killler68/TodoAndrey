package com.example.myapplication.notes.note.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.notes.note.viewmodel.UserNavigatorUseCase
import com.github.terrakok.cicerone.Router

class UserNavigatorUseCaseImpl(
    private val router: Router
) : UserNavigatorUseCase {

    override fun invoke(userId: Int) = router.navigateTo(Screens.toUser(userId))
}