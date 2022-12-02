package com.example.myapplication.user.pager.usecase

import com.example.myapplication.user.pager.model.FeaturesData

interface FeaturesRepository {

    fun getFeatures(): List<FeaturesData>
    fun getFeature(id: Int): FeaturesData
}