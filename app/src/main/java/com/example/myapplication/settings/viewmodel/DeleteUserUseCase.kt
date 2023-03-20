package com.example.myapplication.settings.viewmodel

interface DeleteUserUseCase {

    suspend operator fun invoke(userId: Int)
}