package com.example.myapplication.weather.repository

import com.example.myapplication.common.api.WeatherApi
import com.example.myapplication.weather.model.WeatherPreviewData
import com.example.myapplication.weather.model.WeatherWeek
import com.example.myapplication.weather.usecase.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(): List<WeatherPreviewData> =
        withContext(Dispatchers.IO) {
            val response = weatherApi.getWeather()
            response.list.map {
                WeatherPreviewData(
                    it.dt,
                    it.weather.first().icon,
                    it.main.temp,
                    it.weather.first().description,
                )
            }
        }
}