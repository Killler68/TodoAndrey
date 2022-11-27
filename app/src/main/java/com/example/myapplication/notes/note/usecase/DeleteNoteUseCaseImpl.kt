package com.example.myapplication.notes.note.usecase

import com.example.myapplication.notes.common.model.NotesData
import com.example.myapplication.notes.note.viewmodel.DeleteNoteUseCase

class DeleteNoteUseCaseImpl(private val repository: DeleteNoteRepository) : DeleteNoteUseCase {

    override fun invoke(notesData: NotesData) = repository.deleteNote(notesData)
}