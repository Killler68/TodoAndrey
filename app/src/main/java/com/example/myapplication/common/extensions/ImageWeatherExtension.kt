package com.example.myapplication.common.extensions

import com.example.myapplication.R

fun String.imageWeatherExtension(): Int {
    return when (this) {
        "01d" -> R.drawable.sun
        "02d" -> R.drawable.sun
        "03d" -> R.drawable.sun
        "04d" -> R.drawable.cloud_sun
        "09d" -> R.drawable.heavy_rain
        "10d" -> R.drawable.heavy_rain
        "11d" -> R.drawable.thunder
        "13d" -> R.drawable.winter
        "50d" -> R.drawable.cloud_sun
        "01n" -> R.drawable.sun
        "02n" -> R.drawable.sun
        "03n" -> R.drawable.cloud_sun
        "04n" -> R.drawable.cloud_sun
        "09n" -> R.drawable.heavy_rain
        "10n" -> R.drawable.heavy_rain
        "11n" -> R.drawable.thunder
        "13n" -> R.drawable.winter
        "50n" -> R.drawable.winter
        else -> R.drawable.sun
    }
}