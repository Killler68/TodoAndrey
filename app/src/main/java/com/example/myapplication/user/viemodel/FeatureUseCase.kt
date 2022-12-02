package com.example.myapplication.user.viemodel

import com.example.myapplication.user.pager.model.FeaturesData

interface FeatureUseCase {

    operator fun invoke(id: Int): FeaturesData
}