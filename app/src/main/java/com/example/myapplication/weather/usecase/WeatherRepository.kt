package com.example.myapplication.weather.usecase

import com.example.myapplication.weather.model.WeatherPreviewData
import com.example.myapplication.weather.model.WeatherWeek

interface WeatherRepository {

    suspend fun getWeather(): List<WeatherPreviewData>
    suspend fun getWeatherWeek(): List<WeatherWeek>
}