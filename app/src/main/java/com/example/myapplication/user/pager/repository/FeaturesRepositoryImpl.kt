package com.example.myapplication.user.pager.repository

import com.example.myapplication.R
import com.example.myapplication.authorization.AuthorizationFragment
import com.example.myapplication.notes.note.NotesFragment
import com.example.myapplication.registration.RegistrationFragment
import com.example.myapplication.user.pager.model.FeaturesData
import com.example.myapplication.user.pager.usecase.FeaturesRepository

class
FeaturesRepositoryImpl : FeaturesRepository {

    override fun getFeatures(userId: Int): List<FeaturesData> = testFeatures(userId)

    override fun getFeature(userId: Int, featureId: Int): FeaturesData {
        return testFeatures(featureId).find { it.id == featureId }!!
    }
}

private fun testFeatures(userId: Int) = listOf(
    FeaturesData(
        1,
        "Заметка",
        "Заметка - краткое сообщение, в котором излагается какой-либо факт или ставится конкретный вопрос. ",
        R.mipmap.image_note,
        NotesFragment.newInstance(userId)
    ),
    FeaturesData(2, "Тест", "Тестовое описание", R.mipmap.image_note, RegistrationFragment()),
    FeaturesData(3, "Тест 2", "Тестовое описание 2", R.mipmap.image_note, AuthorizationFragment()),
)