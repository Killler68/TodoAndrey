package com.example.myapplication.notes.note.usecase

interface DeleteNoteRepository {

   suspend fun deleteNote(id: Int)
}