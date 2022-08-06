package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.NotesData
import com.example.myapplication.repository.NotesRepository

class NotesAddViewModel(private val notesRepository: NotesRepository) : ViewModel() {

    private var _data: MutableLiveData<NotesData> = MutableLiveData()

    fun createNotesData(notesData: NotesData) {
        notesRepository.addNotes(notesData)
    }
}