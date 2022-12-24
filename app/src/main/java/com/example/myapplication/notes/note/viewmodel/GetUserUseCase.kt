package com.example.myapplication.notes.note.viewmodel

import com.example.myapplication.common.repository.User

interface GetUserUseCase {

    suspend operator fun invoke(userId: Int): User
}