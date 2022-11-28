package com.example.myapplication.common.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    version = 1,
    entities = [
        NoteTable::class
    ]
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao
}