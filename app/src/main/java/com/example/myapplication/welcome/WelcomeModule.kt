package com.example.myapplication.welcome

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.usecase.RegistrationNavigatorUseCase
import com.example.myapplication.welcome.viewmodel.WelcomeViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class WelcomeModule {

    @Provides
    @IntoMap
    @ClassKey(WelcomeViewModel::class)
    fun provideWelcomeViewModel(
        navigatorToRegistrationUseCase: RegistrationNavigatorUseCase
    ): ViewModel = WelcomeViewModel(
        navigatorToRegistrationUseCase
    )
}