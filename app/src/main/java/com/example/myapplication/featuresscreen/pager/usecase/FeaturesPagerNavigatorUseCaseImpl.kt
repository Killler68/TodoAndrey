package com.example.myapplication.featuresscreen.pager.usecase

import com.example.myapplication.featuresscreen.pager.viewmodel.FeaturesPagerNavigatorUseCase
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FeaturesPagerNavigatorUseCaseImpl(
    private val router: Router,
    private val repository: FeaturesRepository
) : FeaturesPagerNavigatorUseCase {

    override suspend fun invoke(userId: Int, featureId: Int) = withContext(Dispatchers.IO) {
        router.navigateTo(FragmentScreen {
            repository.getFeature(userId, featureId).fragment
                ?: throw Exception("User id: $userId not found")
        })
    }
}