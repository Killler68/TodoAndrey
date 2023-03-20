package com.example.myapplication.common.usecase.getuser

import com.example.myapplication.common.repository.User

interface GetUserUseCase {

    suspend operator fun invoke(id: Int): User
}