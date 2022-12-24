package com.example.myapplication.user.viemodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.emptyUser
import com.example.myapplication.user.pager.model.FeaturesData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val getFeature: FeatureUseCase,
    private val getFeatures: FeaturesUseCase,
    private val getUserUseCase: GetUser,
    private val navigatorToNotes: UserNotesNavigatorUseCase
) : ViewModel() {

    private val _users = MutableStateFlow(emptyUser)
    val user get() = _users.asStateFlow()

    private val _feature: MutableLiveData<FeaturesData> = MutableLiveData()
    val feature: LiveData<FeaturesData> get() = _feature

    private val _features: MutableLiveData<List<FeaturesData>> = MutableLiveData()
    val features: LiveData<List<FeaturesData>> get() = _features

    private val _navCommand: MutableLiveData<NavCommand> = MutableLiveData()
    val navCommand: LiveData<NavCommand> = _navCommand


    fun getUser(id: Int) {
        viewModelScope.launch {
            _users.tryEmit(getUserUseCase(id))
        }
    }

    fun loadFeature(id: Int) {
        _feature.postValue(getFeature(id))
    }

    fun loadFeatures() {
        _features.postValue(getFeatures())
    }

    fun navigateToNotes() {
        _navCommand.postValue(navigatorToNotes())
    }
}