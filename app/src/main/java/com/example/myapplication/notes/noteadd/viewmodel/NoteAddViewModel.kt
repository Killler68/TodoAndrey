package com.example.myapplication.notes.noteadd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.common.usecase.BackNavigatorUseCase
import com.example.myapplication.notes.common.model.Notes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NoteAddViewModel(
    private val backToNotes: BackNavigatorUseCase,
    private val addNote: AddNoteUseCase,
    private val getUser: GetUserAddUseCase
) : ViewModel() {

    private val _user: MutableStateFlow<User> = MutableStateFlow(emptyUser)
    val user get() = _user.asStateFlow()

    fun createNotesData(notes: Notes) {
        viewModelScope.launch {
            addNote(notes)
        }
    }

    fun loadUser(userId: Int) {
        viewModelScope.launch {
            _user.tryEmit(getUser(userId))
        }
    }

    fun navigateToNotes() = backToNotes()
}