package com.example.myapplication.authorization.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.flow.createSharedFlow
import com.example.myapplication.common.navigation.NavCommand
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class AuthorizationViewModel(
    private val navigatorToNotes: AuthorizationNotesNavigatorUseCase
) : ViewModel() {

    private var _navCommand: MutableSharedFlow<NavCommand> = createSharedFlow()
    val navCommand: SharedFlow<NavCommand> = _navCommand.asSharedFlow()

    fun navigateToNotes() = _navCommand.tryEmit(navigatorToNotes())
}