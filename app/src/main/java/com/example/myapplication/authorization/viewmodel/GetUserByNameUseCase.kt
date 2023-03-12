package com.example.myapplication.authorization.viewmodel

interface GetUserByNameUseCase {

    suspend operator fun invoke(name: String)
}