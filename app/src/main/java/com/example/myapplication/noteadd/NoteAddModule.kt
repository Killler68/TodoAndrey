package com.example.myapplication.noteadd

import androidx.lifecycle.ViewModel
import com.example.myapplication.noteadd.router.NoteAddRouterImpl
import com.example.myapplication.noteadd.usecase.NoteAddNotesNavigatorUseCaseImpl
import com.example.myapplication.noteadd.usecase.NoteAddRouter
import com.example.myapplication.noteadd.viewmodel.NoteAddNotesNavigatorUseCase
import com.example.myapplication.noteadd.viewmodel.NoteAddViewModel
import com.example.myapplication.notes.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class NoteAddModule {

    @Provides
    fun provideNoteAddRouter(): NoteAddRouter = NoteAddRouterImpl()

    @Provides
    fun provideNoteAddNotesUseCase(router: NoteAddRouter):
            NoteAddNotesNavigatorUseCase =
        NoteAddNotesNavigatorUseCaseImpl(router)


    @Provides
    @IntoMap
    @ClassKey(NoteAddViewModel::class)
    fun getViewModelNotesAdd(
        notesRepository: NotesRepository,
        navigateToNotesUseCase: NoteAddNotesNavigatorUseCase
    ): ViewModel =
        NoteAddViewModel(
            notesRepository,
            navigateToNotesUseCase
        )
}