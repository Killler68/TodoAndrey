package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.notes.common.model.Notes

interface DeleteNoteUseCase {

    suspend operator fun invoke(id: Int): List<Notes>
}