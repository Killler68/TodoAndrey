package com.example.myapplication.notes.noteadd.usecase

import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.notes.noteadd.viewmodel.GetUserAddUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserAddUseCaseImpl(private val repository: UserRepository) : GetUserAddUseCase {

    override suspend fun invoke(userId: Int): User =
        withContext(Dispatchers.Default) {
            repository.getUser(userId)
        }
}
