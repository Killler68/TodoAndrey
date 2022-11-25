package com.example.myapplication.noteadd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.model.NotesData
import com.example.myapplication.notes.repository.NotesRepository

class NoteAddViewModel(
    private val notesRepository: NotesRepository,
    private val navigatorToNotes: NoteAddNotesNavigatorUseCase
) : ViewModel() {

    private var _data: MutableLiveData<NotesData> = MutableLiveData()

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    fun createNotesData(notesData: NotesData) {
        notesRepository.addNotes(notesData)
    }

    fun navigateToNotes() {
        _navCommand.postValue(navigatorToNotes())
    }
}