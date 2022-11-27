package com.example.myapplication.notes.noteadd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.notes.common.model.NotesData

class NoteAddViewModel(
    private val navigatorToNotes: NoteAddNotesNavigatorUseCase,
    private val addNote: AddNoteUseCase
) : ViewModel() {

    private var _data: MutableLiveData<NotesData> = MutableLiveData()

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    fun createNotesData(notesData: NotesData) {
        addNote(notesData)
    }

    fun navigateToNotes() {
        _navCommand.postValue(navigatorToNotes())
    }
}