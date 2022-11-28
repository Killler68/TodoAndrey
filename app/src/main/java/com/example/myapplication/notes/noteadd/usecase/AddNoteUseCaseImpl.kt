package com.example.myapplication.notes.noteadd.usecase

import com.example.myapplication.notes.common.model.Notes
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.noteadd.viewmodel.AddNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddNoteUseCaseImpl(private val repository: NotesRepository) : AddNoteUseCase {

    override suspend fun invoke(notes: Notes) {
        withContext(Dispatchers.Default) {
            repository.addNotes(notes)
        }
    }
}