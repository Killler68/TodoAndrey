package com.example.myapplication.welcome.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.usecase.RegistrationNavigatorUseCase

class WelcomeViewModel(
    private val navigatorToRegistration: RegistrationNavigatorUseCase
) : ViewModel() {

    fun navigateToRegistration() = navigatorToRegistration()
}