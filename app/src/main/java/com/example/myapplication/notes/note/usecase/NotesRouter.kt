package com.example.myapplication.notes.note.usecase

import com.example.myapplication.common.navigation.NavCommand

interface NotesRouter {

    fun toNoteAdd(userId: Int): NavCommand
    fun toUser(userId: Int): NavCommand
}