package com.example.myapplication.notes.common.model

import com.example.myapplication.common.database.note.models.NoteData

data class Notes(
    val id: Int,
    val title: String,
    val description: String,
)

val emptyList = Notes(
    -1, "", ""
)

fun NoteData.toNote() = Notes(
    id, title, description
)
