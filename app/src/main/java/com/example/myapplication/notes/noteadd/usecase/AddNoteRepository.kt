package com.example.myapplication.notes.noteadd.usecase

import com.example.myapplication.notes.common.model.NotesData

interface AddNoteRepository {

    fun addNotes(notesData: NotesData)
}