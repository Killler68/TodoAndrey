package com.example.myapplication.notes.noteadd.router

import androidx.core.os.bundleOf
import com.example.myapplication.R
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.notes.noteadd.usecase.NoteAddRouter

class NoteAddRouterImpl : NoteAddRouter {

    override fun toNotes(userId: Int): NavCommand =
        NavCommand(R.id.action_fragmentNoteAdd_to_fragmentNotes, bundleOf(USER_ID_KEY to userId))
}