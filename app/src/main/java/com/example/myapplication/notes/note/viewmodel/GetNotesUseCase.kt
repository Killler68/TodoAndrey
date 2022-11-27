package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.notes.common.model.NotesData

interface GetNotesUseCase {

    operator fun invoke(): List<NotesData>
}