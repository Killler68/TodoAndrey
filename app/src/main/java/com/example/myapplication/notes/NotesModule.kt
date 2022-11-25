package com.example.myapplication.notes

import androidx.lifecycle.ViewModel
import com.example.myapplication.notes.repository.NotesRepository
import com.example.myapplication.notes.repository.NotesRepositoryImpl
import com.example.myapplication.noteadd.viewmodel.NotesAddViewModel
import com.example.myapplication.notes.viewmodel.NotesViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
class NotesModule {

    @Provides
    @Singleton
    fun provideNotesRepository(): NotesRepository = NotesRepositoryImpl()

    @Provides
    @IntoMap
    @ClassKey(NotesViewModel::class)
    fun getViewModelNotes(notesRepository: NotesRepository): ViewModel {
        return NotesViewModel(notesRepository)
    }

    @Provides
    @IntoMap
    @ClassKey(NotesAddViewModel::class)
    fun getViewModelNotesAdd(notesRepository: NotesRepository): ViewModel {
        return NotesAddViewModel(notesRepository)
    }
}