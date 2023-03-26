package com.example.myapplication.weather.viewmodel

import com.example.myapplication.weather.model.WeatherData

interface WeatherWeekUseCase {

    suspend operator fun invoke(): List<WeatherData>
}