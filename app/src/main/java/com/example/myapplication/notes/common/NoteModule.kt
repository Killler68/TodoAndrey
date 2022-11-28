package com.example.myapplication.notes.common

import com.example.myapplication.common.database.NoteDao
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.common.repository.NotesRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class NoteModule {

    @Provides
    fun provideNotesRepository(noteDao: NoteDao): NotesRepository = NotesRepositoryImpl(noteDao)
}