package com.example.myapplication.featuresscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.common.usecase.AuthorizationNavigatorUseCase
import com.example.myapplication.common.usecase.getuser.GetUserUseCase
import com.example.myapplication.featuresscreen.pager.model.FeaturesData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FeaturesScreenViewModel(
    private val getFeatures: FeaturesUseCase,
    private val getUserUseCase: GetUserUseCase,
    private val deleteUser: DeleteUserUseCase,
    private val navigatorToAuthorization: AuthorizationNavigatorUseCase,
    private val navigatorToProfile: ProfileNavigatorUseCase
) : ViewModel() {

    private val _users = MutableStateFlow(emptyUser)
    val user get() = _users.asStateFlow()

    private val _features: MutableStateFlow<List<FeaturesData>> = MutableStateFlow(emptyList())
    val features: StateFlow<List<FeaturesData>> get() = _features.asStateFlow()

    fun getUser(id: Int) {
        viewModelScope.launch {
            _users.tryEmit(getUserUseCase(id))
        }
    }

    fun loadFeatures(userId: Int) = _features.tryEmit(getFeatures(userId))

    fun removeUser(userId: Int) {
        viewModelScope.launch {
            deleteUser(userId)
        }
    }

    fun navigateToProfile(userId: Int) = navigatorToProfile(userId)

    fun exit() = navigatorToAuthorization()
}