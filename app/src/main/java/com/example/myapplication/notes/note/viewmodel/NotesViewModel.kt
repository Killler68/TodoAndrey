package com.example.myapplication.notes.note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.common.model.Notes
import com.example.myapplication.notes.note.viewholder.NotesItem
import kotlinx.coroutines.launch

class NotesViewModel(
    private val getNotes: GetNotesUseCase,
    private val deleteNote: DeleteNoteUseCase,
    private val navigatorToNotesAdd: NotesNoteAddNavigatorUseCase
) : ViewModel() {

    private val _model: MutableLiveData<List<Notes>> = MutableLiveData()
    val model: LiveData<List<Notes>> get() = _model

    private val _models: MutableLiveData<List<NotesItem>> = MutableLiveData()
    val models: LiveData<List<NotesItem>> get() = _models

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
            _models.postValue(items)
        }
    }

    private fun deleteNoteData(id: Int) {
        viewModelScope.launch {
            deleteNote(id)
            _model.postValue(getNotes())
        }
    }

    fun navigateToNotesAdd() {
        _navCommand.postValue(navigatorToNotesAdd())
    }
}