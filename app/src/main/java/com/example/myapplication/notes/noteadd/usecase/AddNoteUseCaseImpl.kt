package com.example.myapplication.notes.noteadd.usecase

import com.example.myapplication.notes.common.model.NotesData
import com.example.myapplication.notes.noteadd.viewmodel.AddNoteUseCase

class AddNoteUseCaseImpl(private val repository: AddNoteRepository) : AddNoteUseCase {

    override fun invoke(notesData: NotesData) = repository.addNotes(notesData)
}