package com.example.myapplication.user.usecase

import com.example.myapplication.common.repository.User
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.user.viewmodel.GetUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserImpl(private val repository: UserRepository) : GetUser {

    override suspend fun invoke(id: Int): User =
        withContext(Dispatchers.Default) {
            repository.getUser(id)
        }
}