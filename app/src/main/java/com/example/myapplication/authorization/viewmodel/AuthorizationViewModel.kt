package com.example.myapplication.authorization.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.usecase.RegistrationNavigatorUseCase
import kotlinx.coroutines.launch

class AuthorizationViewModel(
    private val navigatorToRegistration: RegistrationNavigatorUseCase,
    private val getUserByNameAndPassword: GetUserByNameAndPasswordUseCase
) : ViewModel() {

    fun getUseByNameAndPassword(name: String, password: String) {
        viewModelScope.launch {
            getUserByNameAndPassword(name, password)
        }
    }

    fun navigateToNotes() = navigatorToRegistration()
}