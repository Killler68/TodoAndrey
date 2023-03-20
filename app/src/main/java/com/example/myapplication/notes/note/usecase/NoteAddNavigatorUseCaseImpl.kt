package com.example.myapplication.notes.note.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.notes.note.viewmodel.NoteAddNavigatorUseCase
import com.github.terrakok.cicerone.Router

class NoteAddNavigatorUseCaseImpl(
    private val router: Router
) : NoteAddNavigatorUseCase {

    override fun invoke(userId: Int) = router.navigateTo(Screens.toNoteAdd(userId))
//    override fun invoke(userId: Int) = router.replaceScreen(Screens.toNoteAdd(userId))
}