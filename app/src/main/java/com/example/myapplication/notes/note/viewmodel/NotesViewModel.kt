package com.example.myapplication.notes.note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.notes.note.viewholder.NotesItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotesViewModel(
    private val getNotes: GetNotesUseCase,
    private val deleteNote: DeleteNoteUseCase,
    private val getUser: GetUserUseCase,
    private val navigatorToNotesAdd: NotesNoteAddNavigatorUseCase,
    private val navigatorToUser: NotesUserNavigatorUseCase
) : ViewModel() {

    private val _user: MutableStateFlow<User> = MutableStateFlow(emptyUser)
    val user get() = _user.asStateFlow()

    private val _notes: MutableLiveData<List<NotesItem>> = MutableLiveData()
    val notes: LiveData<List<NotesItem>> get() = _notes

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    fun loadNoteData() {
        viewModelScope.launch {
            val data = getNotes()
            val items = data.map {
                NotesItem(
                    it,
                    ::deleteNoteData
                )
            }
            _notes.postValue(items)
        }
    }

    fun loadUser(userId: Int) {
        viewModelScope.launch {
            _user.tryEmit(getUser(userId))
        }
    }

    private fun deleteNoteData(id: Int) {
        viewModelScope.launch {
            deleteNote(id)
            _notes.postValue(getNotes().map {
                NotesItem(
                    it,
                    ::deleteNoteData
                )
            })
        }
    }

    fun navigateToNotesAdd() {
        _navCommand.postValue(navigatorToNotesAdd())
    }

    fun navigateToUser(userId: Int) {
        _navCommand.postValue(navigatorToUser(userId))
    }
}