package com.example.myapplication.featuresscreen.pager.usecase

import com.example.myapplication.featuresscreen.pager.model.FeaturesData

interface FeatureUseCase {

    operator fun invoke(userId: Int, featureId: Int): FeaturesData
}