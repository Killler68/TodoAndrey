package com.example.myapplication.notes.noteadd.usecase

import com.example.myapplication.common.navigation.NavCommand

interface NoteAddRouter {

    fun toNotes(userId: Int): NavCommand
}