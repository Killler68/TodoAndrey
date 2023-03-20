package com.example.myapplication.user.pager.usecase

import com.example.myapplication.user.pager.model.FeaturesData

class FeatureUseCaseImpl(private val repository: FeaturesRepository) : FeatureUseCase {

    override fun invoke(userId: Int, featureId: Int): FeaturesData =
        repository.getFeature(userId, featureId)
}