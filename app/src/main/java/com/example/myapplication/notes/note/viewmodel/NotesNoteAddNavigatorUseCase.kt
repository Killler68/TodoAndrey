package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.common.navigation.NavCommand

interface NotesNoteAddNavigatorUseCase {

    operator fun invoke(userId: Int): NavCommand
}