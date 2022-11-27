package com.example.myapplication.notes.common.repository

import com.example.myapplication.notes.common.model.NotesData
import com.example.myapplication.notes.note.usecase.DeleteNoteRepository
import com.example.myapplication.notes.note.usecase.EditingNoteRepository
import com.example.myapplication.notes.note.usecase.GetNotesRepository
import com.example.myapplication.notes.noteadd.usecase.AddNoteRepository

class NotesRepositoryImpl : GetNotesRepository,AddNoteRepository, DeleteNoteRepository,
    EditingNoteRepository {

    private val notes: MutableList<NotesData> = mutableListOf()

    override fun getNotes(): List<NotesData> = notes
    override fun addNotes(notesData: NotesData) {
        notes.add(notesData)
    }

    override fun deleteNote(notesData: NotesData) {
        notes.remove(notesData)
    }

    override fun editingNote(): List<NotesData> = notes
}