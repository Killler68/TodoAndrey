package com.example.myapplication.user.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.user.viemodel.NotesNavigatorUseCase
import com.github.terrakok.cicerone.Router

class NotesNavigatorUseCaseImpl(
    private val router: Router
) : NotesNavigatorUseCase {

    override fun invoke(userId: Int) = router.navigateTo(Screens.toNotes(userId))
}