package com.example.myapplication.common.database.note.models

data class NoteData(
    val id: Int,
    val userId: Int,
    val title: String,
    val description: String
)
