package com.example.myapplication.user.pager.viewmodel

interface FeaturesPagerNavigatorUseCase {

    suspend operator fun invoke(userId: Int, featureId: Int)
}