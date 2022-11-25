package com.example.myapplication.notes.viewmodel

import com.example.myapplication.common.navigation.NavCommand

interface NotesNoteAddNavigatorUseCase {

    operator fun invoke(): NavCommand
}