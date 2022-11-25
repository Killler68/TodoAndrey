package com.example.myapplication.notes.usecase

import com.example.myapplication.common.navigation.NavCommand

interface NotesRouter {

    fun toNoteAdd(): NavCommand
}