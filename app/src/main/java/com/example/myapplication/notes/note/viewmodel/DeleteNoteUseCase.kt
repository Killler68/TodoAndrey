package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.common.database.note.models.NoteData

interface DeleteNoteUseCase {

    suspend operator fun invoke(id: Int): List<NoteData>
}