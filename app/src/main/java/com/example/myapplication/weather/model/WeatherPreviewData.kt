package com.example.myapplication.weather.model

data class WeatherPreviewData(
    val dt: Long,
    val icon: String,
    val temp: Double,
    val description: String,
)

fun Map<String, List<WeatherPreviewData>>.toWeatherPreviewData() =
    this.map {
        WeatherPreviewData(
            it.value.first().dt,
            it.value.first().icon,
            it.value.first().temp,
            it.value.first().description
        )
    }
