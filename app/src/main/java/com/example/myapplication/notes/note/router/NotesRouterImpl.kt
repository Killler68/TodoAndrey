package com.example.myapplication.notes.note.router

import androidx.core.os.bundleOf
import com.example.myapplication.R
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.notes.note.usecase.NotesRouter

class NotesRouterImpl : NotesRouter {

    override fun toNoteAdd(userId: Int): NavCommand =
        NavCommand(R.id.action_fragmentNotes_to_fragmentNoteAdd, bundleOf(USER_ID_KEY to userId))

    override fun toUser(userId: Int): NavCommand =
        NavCommand(R.id.action_fragmentNotes_to_fragmentUser, bundleOf(USER_ID_KEY to userId))
}