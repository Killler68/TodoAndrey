package com.example.myapplication.hotels.remote.api.dto

data class HotelsResponse(
    val id: Int,
    val name: String,
    val address: String,
    val stars: Double,
    val distance: Double,
    val suites_availability: String
)