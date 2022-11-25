package com.example.myapplication.notes.usecase

import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.viewmodel.NotesNoteAddNavigatorUseCase

class NotesNoteAddNavigatorUseCaseImpl(private val router: NotesRouter) :
NotesNoteAddNavigatorUseCase {

    override fun invoke(): NavCommand = router.toNoteAdd()
}