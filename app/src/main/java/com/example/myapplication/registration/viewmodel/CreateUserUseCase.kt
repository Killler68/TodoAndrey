package com.example.myapplication.registration.viewmodel

interface CreateUserUseCase {

    suspend operator fun invoke(name: String)
}