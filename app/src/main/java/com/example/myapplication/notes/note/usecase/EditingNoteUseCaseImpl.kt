package com.example.myapplication.notes.note.usecase

import com.example.myapplication.notes.common.model.NotesData
import com.example.myapplication.notes.note.viewmodel.EditingNoteUseCase

class EditingNoteUseCaseImpl(private val repository: EditingNoteRepository) : EditingNoteUseCase {

    override fun invoke(): List<NotesData> = repository.editingNote()
}