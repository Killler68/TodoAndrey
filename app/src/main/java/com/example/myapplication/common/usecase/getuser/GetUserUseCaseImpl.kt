package com.example.myapplication.common.usecase.getuser

import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserUseCaseImpl(private val repository: UserRepository) : GetUserUseCase {

    override suspend fun invoke(id: Int): User =
        withContext(Dispatchers.Default) {
            repository.getUser(id)
        }
}