package com.example.myapplication.authorization.usecase

import com.example.myapplication.authorization.viewmodel.GetUserByNameUseCase
import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.common.repository.UserRepository
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserByNameUseCaseImpl(
    private val router: Router,
    private val repository: UserRepository
) : GetUserByNameUseCase {

    override suspend fun invoke(name: String) {
        withContext(Dispatchers.IO) {
            val getUserByName = repository.getUserByName(name)
            router.navigateTo(Screens.toUser(getUserByName))
        }
    }
}