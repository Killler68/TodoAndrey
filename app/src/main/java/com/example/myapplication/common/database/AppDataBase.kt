package com.example.myapplication.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.common.database.note.NoteDao
import com.example.myapplication.common.database.note.NoteTable
import com.example.myapplication.common.database.user.UserDao
import com.example.myapplication.common.database.user.UserTable


@Database(
    version = 1,
    entities = [
        NoteTable::class,
        UserTable::class
    ]
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao
    abstract fun getUserDao(): UserDao
}