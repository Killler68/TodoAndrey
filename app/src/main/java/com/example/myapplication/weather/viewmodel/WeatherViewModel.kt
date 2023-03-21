package com.example.myapplication.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.weather.model.WeatherPreviewData
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherPreview: WeatherPreviewUseCase
) : ViewModel() {

    private val _weatherPreview: MutableLiveData<List<WeatherPreviewData>?> = MutableLiveData()
    val weatherPreview: LiveData<List<WeatherPreviewData>?> get() = _weatherPreview

    fun loadWeatherPreview() {
        viewModelScope.launch {
            _weatherPreview.postValue(getWeatherPreview())
        }
    }
}