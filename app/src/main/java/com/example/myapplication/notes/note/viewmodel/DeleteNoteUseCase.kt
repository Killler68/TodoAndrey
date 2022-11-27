package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.notes.common.model.NotesData
import com.example.myapplication.notes.note.usecase.DeleteNoteRepository

interface DeleteNoteUseCase {

    operator fun invoke(notesData: NotesData)
}