package com.example.myapplication.weather.model

data class WeatherWeek(
    val dt: Long,
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val icon: String
)
