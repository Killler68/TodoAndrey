package com.example.myapplication.notes.note.usecase

import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.notes.note.viewmodel.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserUseCaseImpl(private val repository: UserRepository) : GetUserUseCase {

    override suspend fun invoke(userId: Int): User =
        withContext(Dispatchers.Default) {
            repository.getUser(userId)
        }
}