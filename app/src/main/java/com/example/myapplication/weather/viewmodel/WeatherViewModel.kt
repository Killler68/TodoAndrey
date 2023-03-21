package com.example.myapplication.weather.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.weather.model.WeatherData
import com.example.myapplication.weather.model.WeatherPreviewData
import com.example.myapplication.weather.model.WeatherWeek
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherPreview: WeatherPreviewUseCase,
    private val getWeatherWeek: WeatherWeekUseCase
) : ViewModel() {

    private val _weatherPreview: MutableLiveData<List<WeatherPreviewData>?> = MutableLiveData()
    val weatherPreview: LiveData<List<WeatherPreviewData>?> get() = _weatherPreview

    private val _weatherWeek: MutableLiveData<List<WeatherData>?> = MutableLiveData()
    val weatherWeek: LiveData<List<WeatherData>?> get() = _weatherWeek

    fun loadWeatherPreview() {
        viewModelScope.launch {
            _weatherPreview.postValue(getWeatherPreview())
        }
    }

    fun loadWeatherWeek() {
        viewModelScope.launch {
            _weatherWeek.postValue(getWeatherWeek())
        }
    }
}