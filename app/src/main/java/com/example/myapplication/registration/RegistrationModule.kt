package com.example.myapplication.registration

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.registration.usecase.AuthorizationNavigatorUseCaseImpl
import com.example.myapplication.registration.usecase.CreateUserUseCaseImpl
import com.example.myapplication.registration.viewmodel.AuthorizationNavigatorUseCase
import com.example.myapplication.registration.viewmodel.CreateUserUseCase
import com.example.myapplication.registration.viewmodel.RegistrationViewModel
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class RegistrationModule {

    @Provides
    fun provideRegistrationUseCase(
        userRepository: UserRepository,
        router: Router
    ): CreateUserUseCase =
        CreateUserUseCaseImpl(
            userRepository,
            router
        )

    @Provides
    fun provideAuthorizationUseCase(router: Router): AuthorizationNavigatorUseCase =
        AuthorizationNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(RegistrationViewModel::class)
    fun provideRegistrationViewModel(
        createUserUseCase: CreateUserUseCase,
        navigatorToAuthorizationUseCase: AuthorizationNavigatorUseCase
    ): ViewModel =
        RegistrationViewModel(
            createUserUseCase,
            navigatorToAuthorizationUseCase
        )
}