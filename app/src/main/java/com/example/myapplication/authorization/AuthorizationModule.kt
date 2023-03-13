package com.example.myapplication.authorization

import androidx.lifecycle.ViewModel
import com.example.myapplication.authorization.usecase.GetUserByNameAndPasswordUseCaseImpl
import com.example.myapplication.authorization.viewmodel.AuthorizationViewModel
import com.example.myapplication.authorization.viewmodel.GetUserByNameAndPasswordUseCase
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.common.string.toast.ToastFactory
import com.example.myapplication.common.usecase.RegistrationNavigatorUseCase
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class AuthorizationModule {

    @Provides
    fun provideGetUserByNameAndPassword(
        router: Router,
        userRepository: UserRepository,
        toastFactory: ToastFactory
    ): GetUserByNameAndPasswordUseCase = GetUserByNameAndPasswordUseCaseImpl(
        router,
        userRepository,
        toastFactory
    )

    @Provides
    @IntoMap
    @ClassKey(AuthorizationViewModel::class)
    fun provideAuthorizationViewModel(
        navigatorToRegistrationUseCase: RegistrationNavigatorUseCase,
        getUserByNameAndPasswordUseCase: GetUserByNameAndPasswordUseCase
    ): ViewModel =
        AuthorizationViewModel(
            navigatorToRegistrationUseCase,
            getUserByNameAndPasswordUseCase
        )
}