package com.example.myapplication.common.api

import com.example.myapplication.weather.model.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://api.openweathermap.org"

interface WeatherApi {

    @GET("/data/2.5/forecast?q=Saint%20Petersburg&units=metric&appid=1fb564b0448c20cff8c8a08d408dba5b&lang=ru")
    suspend fun getWeather(): WeatherResponse

    companion object {
        fun create(): WeatherApi {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(WeatherApi::class.java)
        }
    }
}