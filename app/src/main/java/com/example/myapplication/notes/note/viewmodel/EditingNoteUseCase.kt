package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.notes.common.model.NotesData

interface EditingNoteUseCase {

    operator fun invoke(): List<NotesData>
}