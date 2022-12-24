package com.example.myapplication.notes.noteadd

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.note.viewmodel.GetUserUseCase
import com.example.myapplication.notes.noteadd.router.NoteAddRouterImpl
import com.example.myapplication.notes.noteadd.usecase.*
import com.example.myapplication.notes.noteadd.viewmodel.AddNoteUseCase
import com.example.myapplication.notes.noteadd.viewmodel.GetUserAddUseCase
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
    fun provideGetUserAddUseCase(repository: UserRepository): GetUserAddUseCase =
        GetUserAddUseCaseImpl(repository)

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
        noteAdd: AddNoteUseCase,
        getUserUseCase: GetUserAddUseCase
    ): ViewModel =
        NoteAddViewModel(
            navigateToNotesUseCase,
            noteAdd,
            getUserUseCase
        )
}