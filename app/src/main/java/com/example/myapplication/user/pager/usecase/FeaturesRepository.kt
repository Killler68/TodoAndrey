package com.example.myapplication.user.pager.usecase

import com.example.myapplication.user.pager.model.FeaturesData

interface FeaturesRepository {

    fun getFeatures(userId: Int): List<FeaturesData>
    fun getFeature(userId: Int, featureId: Int): FeaturesData
}