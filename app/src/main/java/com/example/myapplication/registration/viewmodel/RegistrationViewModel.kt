package com.example.myapplication.registration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.usecase.AuthorizationNavigatorUseCase
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val navigatorToAuthorization: AuthorizationNavigatorUseCase
) : ViewModel() {

    fun createUser(name: String, password: String) {
        viewModelScope.launch {
            createUserUseCase(name, password)
        }
    }

    fun navigateToAuthorization() = navigatorToAuthorization()
}