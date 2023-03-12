package com.example.myapplication.common.usecase

import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class BackNavigatorModule {

    @Provides
    fun provideBackNavigatorUseCase(router: Router): BackNavigatorUseCase =
        BackNavigatorUseCaseImpl(router)
}