package com.example.myapplication.featuresscreen.pager.viewmodel

interface FeaturesPagerNavigatorUseCase {

    suspend operator fun invoke(userId: Int, featureId: Int)
}