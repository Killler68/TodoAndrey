package com.example.myapplication.notes.note.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.flow.createSharedFlow
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.notes.note.viewholder.NotesItem
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NotesViewModel(
    private val getNotes: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val getUser: GetUserUseCase,
    private val navigatorToNotesAdd: NotesNoteAddNavigatorUseCase,
    private val navigatorToUser: NotesUserNavigatorUseCase
) : ViewModel() {

    private val _user: MutableStateFlow<User> = MutableStateFlow(emptyUser)
    val user get() = _user.asStateFlow()

    private val _notes: MutableStateFlow<List<NotesItem>> = MutableStateFlow(emptyList())
    val notes: StateFlow<List<NotesItem>> get() = _notes.asStateFlow()

    private val _navCommand: MutableSharedFlow<NavCommand> = createSharedFlow()
    val navCommand: SharedFlow<NavCommand> get() = _navCommand.asSharedFlow()

    fun loadNotes() {
        viewModelScope.launch {
            val notes = getNotes()
            val itemNote = notes.map {
                NotesItem(
                    it,
                    ::deleteNote
                )
            }
            _notes.tryEmit(itemNote)
        }
    }

    fun loadUser(userId: Int) {
        viewModelScope.launch {
            _user.tryEmit(getUser(userId))
        }
    }

    private fun deleteNote(id: Int) {
        viewModelScope.launch {
            deleteNoteUseCase(id)
            _notes.tryEmit(getNotes().map {
                NotesItem(
                    it,
                    ::deleteNote
                )
            })
        }
    }

    fun navigateToNotesAdd(userId: Int) = _navCommand.tryEmit(navigatorToNotesAdd(userId))

    fun navigateToUser(userId: Int) = _navCommand.tryEmit(navigatorToUser(userId))

}