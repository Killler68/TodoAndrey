package com.example.myapplication.notes.noteadd.viewmodel

import com.example.myapplication.notes.common.model.Notes

interface AddNoteUseCase {

    suspend operator fun invoke(notes: Notes)
}