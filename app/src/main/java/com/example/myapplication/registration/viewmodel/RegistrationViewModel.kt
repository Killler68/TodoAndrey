package com.example.myapplication.registration.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.common.navigation.NavCommand

class RegistrationViewModel(
    private val navigatorToNotes: RegistrationAuthorizationNavigatorUseCase
) : ViewModel() {

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> get() = _navCommand

    fun navigateToNotes() {
        _navCommand.postValue(navigatorToNotes())
    }
}