package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.common.database.note.models.NoteData

interface GetNotesUseCase {

    suspend operator fun invoke(userId: Int): List<NoteData>
}