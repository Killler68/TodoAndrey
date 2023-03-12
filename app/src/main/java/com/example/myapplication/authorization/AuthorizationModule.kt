package com.example.myapplication.authorization

import androidx.lifecycle.ViewModel
import com.example.myapplication.authorization.usecase.GetUserByNameUseCaseImpl
import com.example.myapplication.authorization.usecase.RegistrationNavigatorUseCaseImpl
import com.example.myapplication.authorization.viewmodel.AuthorizationViewModel
import com.example.myapplication.authorization.viewmodel.GetUserByNameUseCase
import com.example.myapplication.authorization.viewmodel.RegistrationNavigatorUseCase
import com.example.myapplication.common.repository.UserRepository
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class AuthorizationModule {

    @Provides
    fun provideRegistrationNavigatorUseCase(router: Router): RegistrationNavigatorUseCase =
        RegistrationNavigatorUseCaseImpl(router)

    @Provides
    fun provideGetUserByName(
        router: Router,
        userRepository: UserRepository
    ): GetUserByNameUseCase = GetUserByNameUseCaseImpl(
        router,
        userRepository
    )

    @Provides
    @IntoMap
    @ClassKey(AuthorizationViewModel::class)
    fun provideAuthorizationViewModel(
        navigatorToRegistrationUseCase: RegistrationNavigatorUseCase,
        getUserByNameUseCase: GetUserByNameUseCase
    ): ViewModel =
        AuthorizationViewModel(
            navigatorToRegistrationUseCase,
            getUserByNameUseCase
        )
}