package com.example.myapplication.authorization.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.common.navigation.NavCommand

class AuthorizationViewModel(
    private val navigatorToNotes: AuthorizationNotesNavigatorUseCase
) : ViewModel() {

    private var _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> = _navCommand

    fun navigateToNotes() {
        _navCommand.postValue(navigatorToNotes())
    }
}