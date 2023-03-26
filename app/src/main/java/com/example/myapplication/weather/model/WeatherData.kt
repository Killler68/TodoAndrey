package com.example.myapplication.weather.model

data class WeatherData(
    val dt: Long,
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val icon: String,
    val listWeek: List<WeatherWeek>
)
fun Map<String, List<WeatherWeek>>.toWeatherData() =
    this.map {
        WeatherData(
            it.value.first().dt,
            it.value.first().temp,
            it.value.first().temp_min,
            it.value.first().temp_max,
            it.value.first().icon,
            it.value
        )
    }