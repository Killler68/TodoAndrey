package com.example.myapplication.registration.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.registration.viewmodel.CreateUserUseCase
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CreateUserUseCaseImpl(
    private val repository: UserRepository,
    private val router: Router
) : CreateUserUseCase {

    override suspend fun invoke(name: String) =
        withContext(Dispatchers.Default) {
            val user = repository.createUser(name)
            router.navigateTo(Screens.toNotes(user))
        }
}