package com.example.myapplication.featuresscreen.pager.model

import androidx.fragment.app.Fragment

data class FeaturesData(
    val id: Int,
    val title: String,
    val description: String,
    val image: Int,
    val fragment: Fragment?
)