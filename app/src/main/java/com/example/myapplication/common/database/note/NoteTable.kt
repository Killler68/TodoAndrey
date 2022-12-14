package com.example.myapplication.common.database.note

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "notes"
)
data class NoteTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String
)