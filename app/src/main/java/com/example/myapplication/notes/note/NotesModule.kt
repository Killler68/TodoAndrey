package com.example.myapplication.notes.note

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.common.usecase.BackNavigatorUseCase
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.note.usecase.*
import com.example.myapplication.notes.note.viewmodel.*
import com.example.myapplication.notes.noteedit.usecase.NoteEditNavigatorUseCaseImpl
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class NotesModule {

    @Provides
    fun provideNoteAddNavigatorUseCase(router: Router): NoteAddNavigatorUseCase =
        NoteAddNavigatorUseCaseImpl(router)

    @Provides
    fun provideGetUserUseCase(repository: UserRepository): GetUserUseCase =
        GetUserUseCaseImpl(repository)

    @Provides
    fun provideGetNotesUseCase(repository: NotesRepository): GetNotesUseCase =
        GetNotesUseCaseImpl(repository)

    @Provides
    fun provideDeleteNoteUseCase(repository: NotesRepository): DeleteNoteUseCase =
        DeleteNoteUseCaseImpl(repository)

    @Provides
    fun provideNoteEditUseCase(router: Router): NoteEditNavigatorUseCase =
        NoteEditNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(NotesViewModel::class)
    fun getViewModelNotes(
        getNotesUseCase: GetNotesUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        getUserUseCase: GetUserUseCase,
        backToUserUseCase: BackNavigatorUseCase,
        navigatorToNoteAddUseCase: NoteAddNavigatorUseCase,
        navigatorToNoteEditUseCase: NoteEditNavigatorUseCase
    ): ViewModel = NotesViewModel(
        getNotesUseCase,
        deleteNoteUseCase,
        getUserUseCase,
        backToUserUseCase,
        navigatorToNoteAddUseCase,
        navigatorToNoteEditUseCase
    )
}
