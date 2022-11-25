package com.example.myapplication.noteadd.router

import com.example.myapplication.R
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.noteadd.usecase.NoteAddRouter

class NoteAddRouterImpl : NoteAddRouter {

    override fun toNotes(): NavCommand =
        NavCommand(R.id.action_fragmentNoteAdd_to_fragmentNotes)
}