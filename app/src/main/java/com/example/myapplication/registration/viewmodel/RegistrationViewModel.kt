package com.example.myapplication.registration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegistrationViewModel(
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {

    fun createUser(name: String) {
        viewModelScope.launch {
            createUserUseCase(name)
        }
    }
}