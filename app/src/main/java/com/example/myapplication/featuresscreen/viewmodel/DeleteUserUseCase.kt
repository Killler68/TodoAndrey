package com.example.myapplication.featuresscreen.viewmodel

interface DeleteUserUseCase {

    suspend operator fun invoke(userId: Int)
}