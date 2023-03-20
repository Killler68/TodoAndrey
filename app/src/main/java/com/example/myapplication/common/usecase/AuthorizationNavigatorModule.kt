package com.example.myapplication.common.usecase

import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class AuthorizationNavigatorModule {


    @Provides
    fun provideAuthorizationUseCase(router: Router): AuthorizationNavigatorUseCase =
        AuthorizationNavigatorUseCaseImpl(router)
}