package com.example.myapplication.notes.note

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.note.router.NotesRouterImpl
import com.example.myapplication.notes.note.usecase.*
import com.example.myapplication.notes.note.viewmodel.*
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class NotesModule {

    @Provides
    fun provideGetUserUseCase(repository: UserRepository): GetUserUseCase =
        GetUserUseCaseImpl(repository)

    @Provides
    fun provideNotesRouter(): NotesRouter = NotesRouterImpl()

    @Provides
    fun provideNotesNoteAddNavigatorUseCase(router: NotesRouter):
            NotesNoteAddNavigatorUseCase =
        NotesNoteAddNavigatorUseCaseImpl(router)

    @Provides
    fun provideNotesUserNavigatorUseCase(router: NotesRouter):
            NotesUserNavigatorUseCase = NotesUserNavigatorUseCaseImpl(router)

    @Provides
    fun provideGetNotesUseCase(repository: NotesRepository): GetNotesUseCase =
        GetNotesUseCaseImpl(repository)

    @Provides
    fun provideDeleteNoteUseCase(repository: NotesRepository): DeleteNoteUseCase =
        DeleteNoteUseCaseImpl(repository)

    @Provides
    @IntoMap
    @ClassKey(NotesViewModel::class)
    fun getViewModelNotes(
        getNotesUseCase: GetNotesUseCase,
        deleteNoteUseCase: DeleteNoteUseCase,
        getUserUseCase: GetUserUseCase,
        navigateToNoteAddUseCase: NotesNoteAddNavigatorUseCase,
        navigateToUserUseCase: NotesUserNavigatorUseCase
    ): ViewModel = NotesViewModel(
        getNotesUseCase,
        deleteNoteUseCase,
        getUserUseCase,
        navigateToNoteAddUseCase,
        navigateToUserUseCase
    )
}
