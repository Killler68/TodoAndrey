package com.example.myapplication.weather.usecase

import com.example.myapplication.common.extensions.dateFormatUnixTime
import com.example.myapplication.weather.model.WeatherData
import com.example.myapplication.weather.model.WeatherWeek
import com.example.myapplication.weather.model.toWeatherData
import com.example.myapplication.weather.viewmodel.WeatherWeekUseCase
import kotlinx.coroutines.coroutineScope

class WeatherWeekUseCaseImpl(
    private val repository: WeatherRepository
) : WeatherWeekUseCase {

    private val weatherDays = mutableMapOf<String, MutableList<WeatherWeek>>()

    override suspend fun invoke(): List<WeatherData> = coroutineScope {
        repository.getWeatherWeek().forEach {
            if (weatherDays[it.dt.dateFormatUnixTime()] != null)
                weatherDays[it.dt.dateFormatUnixTime()]?.add(it)
            else weatherDays[it.dt.dateFormatUnixTime()] = mutableListOf(it)
        }
        val weatherDataWithOutLastElement = weatherDays.toWeatherData().toMutableList()
        weatherDataWithOutLastElement.removeLast()
        weatherDataWithOutLastElement
    }
}