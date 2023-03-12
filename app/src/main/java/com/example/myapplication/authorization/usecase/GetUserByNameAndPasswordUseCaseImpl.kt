package com.example.myapplication.authorization.usecase

import com.example.myapplication.authorization.viewmodel.GetUserByNameAndPasswordUseCase
import com.example.myapplication.common.navigation.Screens
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.common.string.toast.ToastFactory
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserByNameAndPasswordUseCaseImpl(
    private val router: Router,
    private val repository: UserRepository,
    private val toast: ToastFactory
) : GetUserByNameAndPasswordUseCase {

    override suspend fun invoke(name: String, password: String) {
        withContext(Dispatchers.IO) {
            try {
                val getUserByName = repository.getUserByNameAndPassword(name, password)
                router.navigateTo(Screens.toUser(getUserByName))
            } catch (e: Exception) {
                toast.show("Неверно введено имя")
            }
        }
    }
}