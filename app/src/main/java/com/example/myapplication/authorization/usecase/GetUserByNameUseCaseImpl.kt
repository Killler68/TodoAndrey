package com.example.myapplication.authorization.usecase

import com.example.myapplication.authorization.viewmodel.GetUserByNameUseCase
import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.common.string.toast.ToastFactory
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserByNameUseCaseImpl(
    private val router: Router,
    private val repository: UserRepository,
    private val toast: ToastFactory
) : GetUserByNameUseCase {

    override suspend fun invoke(name: String) {
        withContext(Dispatchers.IO) {
            try {
                val getUserByName = repository.getUserByNameAndPassword(name)
                router.navigateTo(Screens.toUser(getUserByName))
            } catch (e: Exception) {
                toast.show("Неверно введено имя")
            }
        }
    }
}