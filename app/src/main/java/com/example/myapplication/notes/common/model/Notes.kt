package com.example.myapplication.notes.common.model

import com.example.myapplication.common.database.note.models.NoteData

data class Notes(
    val id: Int,
    val userId: Int,
    val title: String,
    val description: String,
)

val emptyList = NoteData(
    -1,0, "", ""
)

fun NoteData.toNote() = Notes(
    id, userId, title, description
)
