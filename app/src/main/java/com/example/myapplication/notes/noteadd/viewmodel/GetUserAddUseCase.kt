package com.example.myapplication.notes.noteadd.viewmodel

import com.example.myapplication.common.repository.User

interface GetUserAddUseCase {

    suspend operator fun invoke(userId: Int): User
}