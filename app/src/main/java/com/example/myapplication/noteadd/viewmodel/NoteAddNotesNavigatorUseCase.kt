package com.example.myapplication.noteadd.viewmodel

import com.example.myapplication.common.navigation.NavCommand

interface NoteAddNotesNavigatorUseCase {

    operator fun invoke(): NavCommand
}