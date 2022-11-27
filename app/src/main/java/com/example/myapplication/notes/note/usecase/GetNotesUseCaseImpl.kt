package com.example.myapplication.notes.note.usecase

import com.example.myapplication.notes.common.model.NotesData
import com.example.myapplication.notes.note.viewmodel.GetNotesUseCase

class GetNotesUseCaseImpl(private val repository: GetNotesRepository) : GetNotesUseCase {

    override fun invoke(): List<NotesData> = repository.getNotes()
}