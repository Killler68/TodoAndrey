package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.notes.common.model.Notes

interface GetNotesUseCase {

    suspend operator fun invoke(): List<Notes>
}