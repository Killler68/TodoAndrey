package com.example.myapplication.common.database

import android.content.Context
import androidx.room.Room
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
}