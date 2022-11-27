package com.example.myapplication.notes.note

import androidx.lifecycle.ViewModel
import com.example.myapplication.notes.common.repository.NotesRepositoryImpl
import com.example.myapplication.notes.note.router.NotesRouterImpl
import com.example.myapplication.notes.note.usecase.*
import com.example.myapplication.notes.note.viewmodel.*
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
class NotesModule {

    @Provides
    fun provideNotesRouter(): NotesRouter = NotesRouterImpl()

    @Provides
    fun provideNotesNoteAddNavigatorUseCase(router: NotesRouter):
            NotesNoteAddNavigatorUseCase =
        NotesNoteAddNavigatorUseCaseImpl(router)

    @Provides
    fun provideGetNotesRepository(repository: NotesRepositoryImpl): GetNotesRepository = repository

    @Provides
    fun provideDeleteNoteRepository(repository: NotesRepositoryImpl): DeleteNoteRepository = repository

    @Provides
    fun provideEditingNoteRepository(repository: NotesRepositoryImpl): EditingNoteRepository = repository

    @Provides
    fun provideGetNotesUseCase(repository: GetNotesRepository): GetNotesUseCase =
        GetNotesUseCaseImpl(repository)

    @Provides
    fun provideDeleteNoteUseCase(repository: DeleteNoteRepository): DeleteNoteUseCase =
        DeleteNoteUseCaseImpl(repository)

    @Provides
    fun provideEditingNoteUseCase(repository: EditingNoteRepository): EditingNoteUseCase =
        EditingNoteUseCaseImpl(repository)

    @Provides
    @IntoMap
    @ClassKey(NotesViewModel::class)
    fun getViewModelNotes(
        getNotesUseCase: GetNotesUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        editingNoteUseCase: EditingNoteUseCase,
        navigateToNoteAddUseCase: NotesNoteAddNavigatorUseCase
    ): ViewModel = NotesViewModel(
        getNotesUseCase,
        deleteNoteUseCase,
        editingNoteUseCase,
        navigateToNoteAddUseCase
    )
}
