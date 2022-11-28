package com.example.myapplication.notes.noteadd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.common.model.Notes
import kotlinx.coroutines.launch

class NoteAddViewModel(
    private val navigatorToNotes: NoteAddNotesNavigatorUseCase,
    private val addNote: AddNoteUseCase
) : ViewModel() {

    private var _data: MutableLiveData<Notes> = MutableLiveData()

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    fun createNotesData(notes: Notes) {
        viewModelScope.launch {
            addNote(notes)
        }
    }

    fun navigateToNotes() {
        _navCommand.postValue(navigatorToNotes())
    }
}