package com.example.myapplication.common.database

import android.content.Context
import androidx.room.Room
import com.example.myapplication.common.database.note.NoteDao
import com.example.myapplication.common.database.user.UserDao
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    fun provideDataBase(context: Context): AppDataBase =
        Room.databaseBuilder(context, AppDataBase::class.java, "database.db")
            .build()

    @Provides
    fun provideNoteDao(appDataBase: AppDataBase): NoteDao =
        appDataBase.getNoteDao()

    @Provides
    fun provideUserDao(appDataBase: AppDataBase): UserDao =
        appDataBase.getUserDao()
}