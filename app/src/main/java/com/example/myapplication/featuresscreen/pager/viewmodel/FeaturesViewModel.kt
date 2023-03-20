package com.example.myapplication.featuresscreen.pager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.featuresscreen.pager.model.FeaturesData
import com.example.myapplication.featuresscreen.pager.usecase.FeatureUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private val emptyFeaturesData = FeaturesData(id = 0, title = "", description = "", image = 0, null)


class FeaturesViewModel(
    private val getFeature: FeatureUseCase,
    private val navigatorToFeature: FeaturesPagerNavigatorUseCase,
) : ViewModel() {

    private val _feature: MutableStateFlow<FeaturesData> = MutableStateFlow(emptyFeaturesData)
    val feature: StateFlow<FeaturesData> get() = _feature.asStateFlow()

    fun loadFeature(userId: Int, featureId: Int) = _feature.tryEmit(getFeature(userId ,featureId))

    fun toFeature(userId: Int, featureId: Int) {
        viewModelScope.launch {
            navigatorToFeature(userId, featureId)
        }
    }
}