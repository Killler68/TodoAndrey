package com.example.myapplication.notes.common.repository

import com.example.myapplication.common.database.note.models.NoteData
import com.example.myapplication.common.database.note.tuples.CreateNoteTuple
import com.example.myapplication.notes.common.model.Notes

interface NotesRepository {

    suspend fun getNote(id: Int): NoteData
    suspend fun getNotes(userId: Int): List<NoteData>
    suspend fun addNotes(noteData: CreateNoteTuple): Notes
    suspend fun deleteNote(id: Int)
}