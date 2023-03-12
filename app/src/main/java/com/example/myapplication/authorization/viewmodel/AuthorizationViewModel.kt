package com.example.myapplication.authorization.viewmodel

import androidx.lifecycle.ViewModel

class AuthorizationViewModel(
    private val navigatorToRegistration: RegistrationNavigatorUseCase
) : ViewModel() {

    fun navigateToNotes() = navigatorToRegistration()
}