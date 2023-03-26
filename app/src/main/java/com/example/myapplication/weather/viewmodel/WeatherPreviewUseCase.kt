package com.example.myapplication.weather.viewmodel

import com.example.myapplication.weather.model.WeatherPreviewData

interface WeatherPreviewUseCase {

    suspend operator fun invoke(): List<WeatherPreviewData>
}