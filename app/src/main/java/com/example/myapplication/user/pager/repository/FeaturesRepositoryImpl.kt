package com.example.myapplication.user.pager.repository

import com.example.myapplication.R
import com.example.myapplication.user.pager.model.FeaturesData
import com.example.myapplication.user.pager.usecase.FeaturesRepository

class FeaturesRepositoryImpl : FeaturesRepository {

    override fun getFeatures(): List<FeaturesData> {
        return testFeatures
    }

    override fun getFeature(id: Int): FeaturesData {
        return testFeatures.find { it.id == id }!!
    }
}

private val testFeatures = listOf(
    FeaturesData(
        0,
        "Заметка",
        "Заметка - газетный жанр, краткое сообщение, в котором излагается какой-либо факт или ставится конкретный вопрос. ",
        R.mipmap.image_note
    ),
    FeaturesData(1, "Hi", "", R.mipmap.image_note),
    FeaturesData(2, "Привет", "", R.mipmap.image_note),
)