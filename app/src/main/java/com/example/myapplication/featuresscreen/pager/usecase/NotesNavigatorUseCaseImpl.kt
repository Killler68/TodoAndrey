package com.example.myapplication.featuresscreen.pager.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.featuresscreen.pager.viewmodel.NotesNavigatorUseCase
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesNavigatorUseCaseImpl(
    private val router: Router
) : NotesNavigatorUseCase {

    override suspend operator fun invoke(userId: Int) = withContext(Dispatchers.IO) {
        router.navigateTo(Screens.toNotes(userId))
    }
}