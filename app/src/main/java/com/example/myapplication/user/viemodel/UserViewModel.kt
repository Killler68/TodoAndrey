package com.example.myapplication.user.viemodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.user.pager.model.FeaturesData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val getFeatures: FeaturesUseCase,
    private val getUserUseCase: GetUser
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

}