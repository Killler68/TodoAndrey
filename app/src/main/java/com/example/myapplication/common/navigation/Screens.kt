package com.example.myapplication.common.navigation

import com.example.myapplication.common.repository.User
import com.example.myapplication.notes.note.NotesFragment
import com.example.myapplication.notes.noteadd.NoteAddFragment
import com.example.myapplication.registration.RegistrationFragment
import com.example.myapplication.user.UserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun toRegistration() = FragmentScreen { RegistrationFragment() }
    fun toNotes(userId: Int) = FragmentScreen { NotesFragment.newInstance(userId) }
    fun toNoteAdd(userId: Int) = FragmentScreen { NoteAddFragment.newInstance(userId) }
    fun toUser(user: User) = FragmentScreen { UserFragment.newInstance(user) }
}