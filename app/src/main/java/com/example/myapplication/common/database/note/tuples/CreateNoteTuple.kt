package com.example.myapplication.common.database.note.tuples

data class CreateNoteTuple(
    val userId: Int,
    val title: String,
    val description: String
)
data class DeleteNoteTuple(val id: Int)
