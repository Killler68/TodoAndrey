package com.example.myapplication.notes.note.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.notes.note.viewholder.NotesItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val getNotes: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val getUser: GetUserUseCase,
    private val navigatorToUser: UserNavigatorUseCase,
    private val navigatorToNoteAdd: NoteAddNavigatorUseCase
) : ViewModel() {

    private val _user: MutableStateFlow<User> = MutableStateFlow(emptyUser)
    val user get() = _user.asStateFlow()

    private val _notes: MutableStateFlow<List<NotesItem>> = MutableStateFlow(emptyList())
    val notes: StateFlow<List<NotesItem>> get() = _notes.asStateFlow()

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

    fun navigateToNoteAdd(userId: Int) = navigatorToNoteAdd(userId)

    fun navigateToUser(userId: Int) = navigatorToUser(userId)
}