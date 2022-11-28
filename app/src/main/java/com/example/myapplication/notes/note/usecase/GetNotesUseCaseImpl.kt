package com.example.myapplication.notes.note.usecase

import com.example.myapplication.notes.common.model.Notes
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.note.viewmodel.GetNotesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNotesUseCaseImpl(private val repository: NotesRepository) : GetNotesUseCase {

    override suspend fun invoke(): List<Notes> = withContext(Dispatchers.Default) {
        repository.getNotes()
    }
}