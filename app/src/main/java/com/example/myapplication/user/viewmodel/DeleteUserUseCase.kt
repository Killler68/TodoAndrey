package com.example.myapplication.user.viewmodel

interface DeleteUserUseCase {

    suspend operator fun invoke(userId: Int)
}