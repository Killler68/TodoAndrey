package com.example.myapplication.notes.noteadd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.flow.createSharedFlow
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.notes.common.model.Notes
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NoteAddViewModel(
    private val navigatorToNotes: NoteAddNotesNavigatorUseCase,
    private val addNote: AddNoteUseCase,
    private val getUser: GetUserAddUseCase
) : ViewModel() {

    private val _user: MutableStateFlow<User> = MutableStateFlow(emptyUser)
    val user get() = _user.asStateFlow()

    private val _navCommand: MutableSharedFlow<NavCommand> = createSharedFlow()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

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

    fun navigateToNotes(userId: Int) = _navCommand.tryEmit(navigatorToNotes(userId))

}