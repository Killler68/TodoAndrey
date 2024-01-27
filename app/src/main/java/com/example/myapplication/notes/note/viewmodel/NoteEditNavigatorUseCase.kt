package com.example.myapplication.notes.note.viewmodel

interface NoteEditNavigatorUseCase {

    operator fun invoke(useId: Int, noteId: Int)
}