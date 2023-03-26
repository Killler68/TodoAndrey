package com.example.myapplication.weather.model

data class WeatherResponse(
    val cod: String,
    val message: String,
    val cnt: String,
    val list: List<WeatherList>,
    val city: City,
)

data class WeatherList(
    val dt: Long,
    val main: WeatherMain,
    val weather: List<WeatherToDay>,
    val clouds: WeatherClouds,
    val wind: WeatherWind,
    val sys: WeatherSys,
)

data class WeatherMain(
    val temp: Double,
    val feels_like: String,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: String,
    val sea_level: String,
    val grnd_level: String,
    val humidity: String,
    val temp_kf: String,
)

data class WeatherToDay(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class WeatherClouds(
    val all: String
)

data class WeatherWind(
    val speed: String,
    val deg: String,
    val gust: String,
    val visibility: String,
    val pop: String,
)

data class WeatherSys(
    val pod: String,
    val dt_txt: String
)

data class City(
    val id: Int,
    val name: String,
    val coord: WeatherCoord,
    val country: String
)

data class WeatherCoord(
    val lat: Float,
    val lon: Float
)