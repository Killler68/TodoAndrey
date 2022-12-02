package com.example.myapplication.registration

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.registration.router.RegistrationRouterImpl
import com.example.myapplication.registration.usecase.CreateUserUseCaseImpl
import com.example.myapplication.registration.usecase.RegistrationRouter
import com.example.myapplication.registration.viewmodel.CreateUserUseCase
import com.example.myapplication.registration.viewmodel.RegistrationViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class RegistrationModule {

    @Provides
    fun provideCreateUserRouter(): RegistrationRouter = RegistrationRouterImpl()

    @Provides
    fun provideRegistrationUseCase(
        userRepository: UserRepository,
        router: RegistrationRouter
    ): CreateUserUseCase =
        CreateUserUseCaseImpl(
            userRepository,
            router
        )

    @Provides
    @IntoMap
    @ClassKey(RegistrationViewModel::class)
    fun provideRegistrationViewModel(
        createUserUseCase: CreateUserUseCase
    ): ViewModel =
        RegistrationViewModel(
            createUserUseCase
        )
}