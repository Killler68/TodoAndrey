package com.example.myapplication.user.pager.usecase

import com.example.myapplication.user.pager.model.FeaturesData
import com.example.myapplication.user.viewmodel.FeaturesUseCase

class FeaturesUseCaseImpl(private val repository: FeaturesRepository) : FeaturesUseCase {

    override fun invoke(userId: Int): List<FeaturesData> = repository.getFeatures(userId)
}