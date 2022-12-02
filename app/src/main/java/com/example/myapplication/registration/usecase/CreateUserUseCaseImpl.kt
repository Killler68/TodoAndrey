package com.example.myapplication.registration.usecase

import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.registration.viewmodel.CreateUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CreateUserUseCaseImpl(
    private val repository: UserRepository,
    private val router: RegistrationRouter
) : CreateUserUseCase {

    override suspend fun invoke(name: String): NavCommand =
        withContext(Dispatchers.Default) {
            val user = repository.createUser(name)

            router.toNotes(user)
        }
}