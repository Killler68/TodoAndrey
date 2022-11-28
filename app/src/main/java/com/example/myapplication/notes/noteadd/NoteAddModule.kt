package com.example.myapplication.notes.noteadd

import androidx.lifecycle.ViewModel
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.common.repository.NotesRepositoryImpl
import com.example.myapplication.notes.noteadd.router.NoteAddRouterImpl
import com.example.myapplication.notes.noteadd.usecase.AddNoteRepository
import com.example.myapplication.notes.noteadd.usecase.AddNoteUseCaseImpl
import com.example.myapplication.notes.noteadd.usecase.NoteAddNotesNavigatorUseCaseImpl
import com.example.myapplication.notes.noteadd.usecase.NoteAddRouter
import com.example.myapplication.notes.noteadd.viewmodel.AddNoteUseCase
import com.example.myapplication.notes.noteadd.viewmodel.NoteAddNotesNavigatorUseCase
import com.example.myapplication.notes.noteadd.viewmodel.NoteAddViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class NoteAddModule {

    @Provides
    fun provideNoteAddRouter(): NoteAddRouter = NoteAddRouterImpl()

    @Provides
    fun provideAddNoteUseCase(repository: NotesRepository): AddNoteUseCase =
        AddNoteUseCaseImpl(repository)

    @Provides
    fun provideNoteAddNotesUseCase(router: NoteAddRouter):
            NoteAddNotesNavigatorUseCase =
        NoteAddNotesNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(NoteAddViewModel::class)
    fun getViewModelNotesAdd(
        navigateToNotesUseCase: NoteAddNotesNavigatorUseCase,
        noteAdd: AddNoteUseCase
    ): ViewModel =
        NoteAddViewModel(
            navigateToNotesUseCase,
            noteAdd
        )
}