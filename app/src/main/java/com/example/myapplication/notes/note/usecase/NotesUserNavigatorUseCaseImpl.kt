package com.example.myapplication.notes.note.usecase

import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.note.viewmodel.NotesUserNavigatorUseCase

class NotesUserNavigatorUseCaseImpl(private val router: NotesRouter) :
    NotesUserNavigatorUseCase {

    override fun invoke(userId: Int): NavCommand = router.toUser(userId)
}