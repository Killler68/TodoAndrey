package com.example.myapplication.registration.viewmodel

import com.example.myapplication.common.navigation.NavCommand

interface CreateUserUseCase {

    suspend operator fun invoke(name: String): NavCommand
}