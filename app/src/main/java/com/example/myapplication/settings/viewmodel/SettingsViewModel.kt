package com.example.myapplication.settings.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.usecase.BackNavigatorUseCase
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val backNavigator: BackNavigatorUseCase,
    private val deleteUser: DeleteUserUseCase
) : ViewModel() {

    fun removeUser(userId: Int) {
        viewModelScope.launch {
            deleteUser(userId)
        }
    }

    fun back() = backNavigator()
}