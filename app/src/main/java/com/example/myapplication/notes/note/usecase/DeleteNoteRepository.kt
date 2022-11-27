package com.example.myapplication.notes.note.usecase

import com.example.myapplication.notes.common.model.NotesData

interface DeleteNoteRepository {

    fun deleteNote(notesData: NotesData)
}