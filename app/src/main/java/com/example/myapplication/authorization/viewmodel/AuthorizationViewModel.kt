package com.example.myapplication.authorization.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthorizationViewModel(
    private val navigatorToRegistration: RegistrationNavigatorUseCase,
    private val getUserByNameUseCase: GetUserByNameUseCase
) : ViewModel() {

    fun getUseByName(name: String) {
        viewModelScope.launch {
            getUserByNameUseCase(name)
        }
    }

    fun navigateToNotes() = navigatorToRegistration()
}