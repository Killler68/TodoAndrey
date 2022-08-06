package com.example.myapplication.repository

import com.example.myapplication.model.NotesData

interface NotesRepository {
    fun getNotes(): List<NotesData>
    fun addNotes(notesData: NotesData)
    fun deleteNote(notesData: NotesData)
    fun editingNotes(): List<NotesData>
}
