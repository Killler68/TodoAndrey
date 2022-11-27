package com.example.myapplication.notes.note.usecase

import com.example.myapplication.notes.common.model.NotesData

interface EditingNoteRepository {

    fun editingNote(): List<NotesData>
}
