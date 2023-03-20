package com.example.myapplication.featuresscreen.pager.usecase

import com.example.myapplication.featuresscreen.pager.model.FeaturesData

interface FeaturesRepository {

    fun getFeatures(userId: Int): List<FeaturesData>
    fun getFeature(userId: Int, featureId: Int): FeaturesData
}