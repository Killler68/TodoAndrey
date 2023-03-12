package com.example.myapplication.notes.noteadd

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.common.usecase.BackNavigatorUseCase
import com.example.myapplication.notes.common.repository.NotesRepository
import com.example.myapplication.notes.noteadd.usecase.*
import com.example.myapplication.notes.noteadd.viewmodel.AddNoteUseCase
import com.example.myapplication.notes.noteadd.viewmodel.GetUserAddUseCase
import com.example.myapplication.notes.noteadd.viewmodel.NoteAddViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class NoteAddModule {

    @Provides
    fun provideGetUserAddUseCase(repository: UserRepository): GetUserAddUseCase =
        GetUserAddUseCaseImpl(repository)

    @Provides
    fun provideAddNoteUseCase(repository: NotesRepository): AddNoteUseCase =
        AddNoteUseCaseImpl(repository)

    @Provides
    @IntoMap
    @ClassKey(NoteAddViewModel::class)
    fun getViewModelNotesAdd(
        backToNotesUseCase: BackNavigatorUseCase,
        noteAdd: AddNoteUseCase,
        getUserUseCase: GetUserAddUseCase
    ): ViewModel =
        NoteAddViewModel(
            backToNotesUseCase,
            noteAdd,
            getUserUseCase
        )
}