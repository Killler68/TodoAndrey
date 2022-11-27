package com.example.myapplication.notes.note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.common.model.NotesData

class NotesViewModel(
    private val getNotes: GetNotesUseCase,
    private val deleteNote: DeleteNoteUseCase,
    private val editingNote: EditingNoteUseCase,
    private val navigatorToNotesAdd: NotesNoteAddNavigatorUseCase
) : ViewModel() {

    private val _model: MutableLiveData<List<NotesData>> = MutableLiveData()
    val model: LiveData<List<NotesData>> get() = _model

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    fun loadNoteData() {
        val data = getNotes()
        _model.postValue(data)
    }

    fun deleteNoteData(notesData: NotesData) {
        deleteNote(notesData)
        _model.postValue(getNotes())
    }

//    fun editingNoteData() {
//        val editData = notesRepository.editingNotes()
//        _model.postValue(editData)
//    }

    fun navigateToNotesAdd() {
        _navCommand.postValue(navigatorToNotesAdd())
    }
}