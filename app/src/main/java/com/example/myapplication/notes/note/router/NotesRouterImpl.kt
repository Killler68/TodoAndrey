package com.example.myapplication.notes.note.router

import com.example.myapplication.R
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.note.usecase.NotesRouter

class NotesRouterImpl : NotesRouter {

    override fun toNoteAdd(): NavCommand =
        NavCommand(R.id.action_fragmentNotes_to_fragmentNoteAdd)
}