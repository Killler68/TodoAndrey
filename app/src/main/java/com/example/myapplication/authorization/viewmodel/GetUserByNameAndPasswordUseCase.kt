package com.example.myapplication.authorization.viewmodel

interface GetUserByNameAndPasswordUseCase {

    suspend operator fun invoke(name: String, password: String)
}