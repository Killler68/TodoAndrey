package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.common.navigation.NavCommand

interface NotesUserNavigatorUseCase {

    operator fun invoke(): NavCommand
}