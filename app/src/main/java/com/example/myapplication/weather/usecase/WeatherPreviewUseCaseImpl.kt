package com.example.myapplication.weather.usecase

import com.example.myapplication.common.extensions.dateFormatUnixTimePreview
import com.example.myapplication.weather.model.WeatherPreviewData
import com.example.myapplication.weather.model.toWeatherPreviewData
import com.example.myapplication.weather.viewmodel.WeatherPreviewUseCase
import kotlinx.coroutines.coroutineScope

class WeatherPreviewUseCaseImpl(
    private val repository: WeatherRepository
) : WeatherPreviewUseCase {

    private val weatherPreview = mutableMapOf<String, MutableList<WeatherPreviewData>>()

    override suspend fun invoke(): List<WeatherPreviewData> {
        return coroutineScope {
            repository.getWeather().forEach {
                if (weatherPreview[it.dt.dateFormatUnixTimePreview()] != null)
                    weatherPreview[it.dt.dateFormatUnixTimePreview()]?.add(it)
                else weatherPreview[it.dt.dateFormatUnixTimePreview()] = mutableListOf()
            }
            weatherPreview.toWeatherPreviewData()
        }
    }
}