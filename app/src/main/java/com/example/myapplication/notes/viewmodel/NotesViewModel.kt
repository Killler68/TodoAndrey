package com.example.myapplication.notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.NotesData
import com.example.myapplication.notes.repository.NotesRepository

class NotesViewModel(private val notesRepository: NotesRepository) : ViewModel() {

    private val _model: MutableLiveData<List<NotesData>> = MutableLiveData()
    val model: LiveData<List<NotesData>> get() = _model

    fun loadNoteData() {
        val data = notesRepository.getNotes()
        _model.postValue(data)
    }

    fun deleteNoteData(notesData: NotesData) {
        notesRepository.deleteNote(notesData)
        _model.postValue(notesRepository.getNotes())
    }

    fun editingNoteData() {
        val editData = notesRepository.editingNotes()
        _model.postValue(editData)
    }
}