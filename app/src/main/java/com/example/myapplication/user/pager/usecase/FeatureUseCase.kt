package com.example.myapplication.user.pager.usecase

import com.example.myapplication.user.pager.model.FeaturesData

interface FeatureUseCase {

    operator fun invoke(userId: Int, featureId: Int): FeaturesData
}