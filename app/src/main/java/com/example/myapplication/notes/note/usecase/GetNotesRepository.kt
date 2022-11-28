package com.example.myapplication.notes.note.usecase

import com.example.myapplication.notes.common.model.Notes

interface GetNotesRepository {

    suspend fun getNote(id: Int): Notes
    suspend fun getNotes(): List<Notes>

}