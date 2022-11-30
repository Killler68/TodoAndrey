package com.example.myapplication.notes.note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.note.viewholder.NotesItem
import kotlinx.coroutines.launch

class NotesViewModel(
    private val getNotes: GetNotesUseCase,
    private val deleteNote: DeleteNoteUseCase,
    private val navigatorToNotesAdd: NotesNoteAddNavigatorUseCase
) : ViewModel() {

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
}