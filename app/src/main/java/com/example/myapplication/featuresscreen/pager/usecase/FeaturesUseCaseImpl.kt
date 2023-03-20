package com.example.myapplication.featuresscreen.pager.usecase

import com.example.myapplication.featuresscreen.pager.model.FeaturesData
import com.example.myapplication.featuresscreen.viewmodel.FeaturesUseCase

class FeaturesUseCaseImpl(private val repository: FeaturesRepository) : FeaturesUseCase {

    override fun invoke(userId: Int): List<FeaturesData> = repository.getFeatures(userId)
}