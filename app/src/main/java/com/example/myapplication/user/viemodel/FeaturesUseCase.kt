package com.example.myapplication.user.viemodel

import com.example.myapplication.user.pager.model.FeaturesData

interface FeaturesUseCase {

    operator fun invoke(userId: Int): List<FeaturesData>
}