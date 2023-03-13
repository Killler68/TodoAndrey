package com.example.myapplication.common.usecase

import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class RegistrationNavigatorModule {

    @Provides
    fun provideRegistrationNavigatorUseCase(router: Router): RegistrationNavigatorUseCase =
        RegistrationNavigatorUseCaseImpl(router)
}