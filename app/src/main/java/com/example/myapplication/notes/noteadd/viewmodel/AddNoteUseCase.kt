package com.example.myapplication.notes.noteadd.viewmodel

import com.example.myapplication.notes.common.model.NotesData

interface AddNoteUseCase {

    operator fun invoke(notesData: NotesData)
}