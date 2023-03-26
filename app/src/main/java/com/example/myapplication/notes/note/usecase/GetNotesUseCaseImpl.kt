package com.example.myapplication.notes.note.usecase

import com.example.myapplication.common.database.note.models.NoteData
import com.example.myapplication.notes.common.model.Notes
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.note.viewmodel.GetNotesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetNotesUseCaseImpl(private val repository: NotesRepository) : GetNotesUseCase {

    override suspend fun invoke(userId: Int): List<Notes>? = withContext(Dispatchers.Default) {
        repository.getNotes(userId)
    }
}