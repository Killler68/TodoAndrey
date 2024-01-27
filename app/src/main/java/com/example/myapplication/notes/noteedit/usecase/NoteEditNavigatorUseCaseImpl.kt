package com.example.myapplication.notes.noteedit.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.notes.note.viewmodel.NoteEditNavigatorUseCase
import com.github.terrakok.cicerone.Router

class NoteEditNavigatorUseCaseImpl(
    private val router: Router,
) : NoteEditNavigatorUseCase {

    override fun invoke(useId: Int, noteId: Int) = router.navigateTo(Screens.toNoteEdit(useId, noteId))
}