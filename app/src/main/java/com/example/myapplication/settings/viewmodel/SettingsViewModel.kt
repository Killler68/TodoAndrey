package com.example.myapplication.settings.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.usecase.BackNavigatorUseCase

class SettingsViewModel(
    private val backNavigator: BackNavigatorUseCase
) : ViewModel() {

    fun back() = backNavigator()
}