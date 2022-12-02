package com.example.myapplication.user.pager.usecase

import com.example.myapplication.user.pager.model.FeaturesData
import com.example.myapplication.user.viemodel.FeatureUseCase

class FeatureUseCaseImpl(private val repository: FeaturesRepository) : FeatureUseCase {

    override fun invoke(id: Int): FeaturesData = repository.getFeature(id)
}