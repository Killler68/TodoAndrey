package com.example.myapplication.notes.note.usecase

import com.example.myapplication.notes.common.model.NotesData

interface GetNotesRepository {

    fun getNotes(): List<NotesData>
}