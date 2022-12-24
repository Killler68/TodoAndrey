package com.example.myapplication.notes.noteadd.usecase

import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.noteadd.viewmodel.NoteAddNotesNavigatorUseCase

class NoteAddNotesNavigatorUseCaseImpl(private val router: NoteAddRouter) :
    NoteAddNotesNavigatorUseCase {

    override fun invoke(userId: Int): NavCommand = router.toNotes(userId)
}