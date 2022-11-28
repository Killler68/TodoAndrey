package com.example.myapplication.common.database.tuples

data class CreateNoteTuple(
    val title: String,
    val description: String
)
data class DeleteNoteTuple(val id: Int)
