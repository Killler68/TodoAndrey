package com.example.myapplication.notes.repository

import com.example.myapplication.model.NotesData

class NotesRepositoryImpl : NotesRepository {

    private val notes: MutableList<NotesData> = mutableListOf()

    override fun getNotes(): List<NotesData> = notes
    override fun addNotes(notesData: NotesData) {
        notes.add(notesData)
    }

    override fun deleteNote(notesData: NotesData) {
        notes.remove(notesData)
    }

    override fun editingNotes(): List<NotesData> = notes
}