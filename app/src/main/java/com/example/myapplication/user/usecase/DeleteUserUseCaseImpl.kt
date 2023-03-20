package com.example.myapplication.user.usecase

import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.user.viewmodel.DeleteUserUseCase
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DeleteUserUseCaseImpl(
    private val repository: UserRepository,
    private val router: Router
) : DeleteUserUseCase {

    override suspend fun invoke(userId: Int) = withContext(Dispatchers.IO) {
        repository.deleteUser(userId)
        router.navigateTo(Screens.toRegistration())
    }
}