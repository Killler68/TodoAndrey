package com.example.myapplication.notes.note.usecase

import com.example.myapplication.notes.common.model.Notes
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.note.viewholder.NotesItem
import com.example.myapplication.notes.note.viewmodel.DeleteNoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteNoteUseCaseImpl(private val repository: NotesRepository) : DeleteNoteUseCase {

    override suspend fun invoke(id: Int): List<Notes> = withContext(Dispatchers.Default) {
        repository.deleteNote(id)
        repository.getNotes()
    }
}