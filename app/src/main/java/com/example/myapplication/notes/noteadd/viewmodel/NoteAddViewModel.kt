package com.example.myapplication.notes.noteadd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.notes.common.model.Notes
import com.example.myapplication.notes.note.viewmodel.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NoteAddViewModel(
    private val navigatorToNotes: NoteAddNotesNavigatorUseCase,
    private val addNote: AddNoteUseCase,
    private val getUser: GetUserAddUseCase
) : ViewModel() {

    private var _data: MutableLiveData<Notes> = MutableLiveData()

    private val _user: MutableStateFlow<User> = MutableStateFlow(emptyUser)
    val user get() = _user.asStateFlow()

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

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


    fun navigateToNotes(userId: Int) {
        _navCommand.postValue(navigatorToNotes(userId))
    }
}