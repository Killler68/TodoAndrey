package com.example.myapplication.featuresscreen.viewmodel

import com.example.myapplication.featuresscreen.pager.model.FeaturesData

interface FeaturesUseCase {

    operator fun invoke(userId: Int): List<FeaturesData>
}