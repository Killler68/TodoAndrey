package com.example.myapplication.weather.usecase

import com.example.myapplication.weather.model.WeatherPreviewData

interface WeatherRepository {

    suspend fun getWeather(): List<WeatherPreviewData>
}