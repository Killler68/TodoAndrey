package com.example.myapplication.notes.noteadd.usecase

import com.example.myapplication.common.database.note.models.NoteData
import com.example.myapplication.notes.common.model.Notes

interface AddNoteRepository {

    suspend fun addNotes(noteData: NoteData): Notes
}