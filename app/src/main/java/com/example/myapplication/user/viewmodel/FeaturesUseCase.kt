package com.example.myapplication.user.viewmodel

import com.example.myapplication.user.pager.model.FeaturesData

interface FeaturesUseCase {

    operator fun invoke(userId: Int): List<FeaturesData>
}