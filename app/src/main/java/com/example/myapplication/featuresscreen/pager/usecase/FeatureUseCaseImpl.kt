package com.example.myapplication.featuresscreen.pager.usecase

import com.example.myapplication.featuresscreen.pager.model.FeaturesData

class FeatureUseCaseImpl(private val repository: FeaturesRepository) : FeatureUseCase {

    override fun invoke(userId: Int, featureId: Int): FeaturesData =
        repository.getFeature(userId, featureId)
}