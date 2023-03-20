package com.example.myapplication.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.common.usecase.BackNavigatorUseCase
import com.example.myapplication.common.usecase.getuser.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val backNavigator: BackNavigatorUseCase
) : ViewModel() {

    private var _user = MutableStateFlow(emptyUser)
    val user get() = _user.asStateFlow()

    fun getUser(userId: Int) {
        viewModelScope.launch {
            _user.tryEmit(getUserUseCase(userId))
        }
    }

    fun back() = backNavigator()
}