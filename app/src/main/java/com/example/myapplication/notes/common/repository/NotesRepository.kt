package com.example.myapplication.notes.common.repository

import com.example.myapplication.common.database.note.models.NoteData
import com.example.myapplication.notes.common.model.Notes

interface NotesRepository {

    suspend fun getNote(id: Int): Notes
    suspend fun getNotes(): List<Notes>
    suspend fun addNotes(noteData: Notes): Notes
    suspend fun deleteNote(id: Int)
}