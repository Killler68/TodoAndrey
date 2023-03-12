package com.example.myapplication.user.viemodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.user.pager.model.FeaturesData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private val emptyFeaturesData = FeaturesData(id = 0, title = "", description = "", image = 0)

class UserViewModel(
    private val getFeature: FeatureUseCase,
    private val getFeatures: FeaturesUseCase,
    private val getUserUseCase: GetUser,
    private val navigatorToNotes: NotesNavigatorUseCase
) : ViewModel() {

    private val _users = MutableStateFlow(emptyUser)
    val user get() = _users.asStateFlow()

    private val _feature: MutableStateFlow<FeaturesData> = MutableStateFlow(emptyFeaturesData)
    val feature: StateFlow<FeaturesData> get() = _feature.asStateFlow()

    private val _features: MutableStateFlow<List<FeaturesData>> = MutableStateFlow(emptyList())
    val features: StateFlow<List<FeaturesData>> get() = _features.asStateFlow()

    fun getUser(id: Int) {
        viewModelScope.launch {
            _users.tryEmit(getUserUseCase(id))
        }
    }

    fun loadFeature(id: Int) = _feature.tryEmit(getFeature(id))

    fun loadFeatures() = _features.tryEmit(getFeatures())

    fun navigateToNotes(userId: Int) = navigatorToNotes(userId)
}