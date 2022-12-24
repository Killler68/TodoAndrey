package com.example.myapplication.notes.note.usecase

import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.note.viewmodel.NotesNoteAddNavigatorUseCase

class NotesNoteAddNavigatorUseCaseImpl(private val router: NotesRouter) :
    NotesNoteAddNavigatorUseCase {

    override fun invoke(userId: Int): NavCommand = router.toNoteAdd(userId)
}