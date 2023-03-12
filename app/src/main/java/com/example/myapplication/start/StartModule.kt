package com.example.myapplication.start

import com.example.myapplication.common.sharedpreferences.LocalStorage
import com.example.myapplication.start.usecase.CheckLocaleUseCaseImpl
import com.example.myapplication.start.viewmodel.CheckLocaleUseCase
import com.example.myapplication.start.viewmodel.StartViewModel
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class StartModule {

    @Provides
    fun provideCheckLocaleUseCase(
        router: Router,
        localStorage: LocalStorage
    ): CheckLocaleUseCase = CheckLocaleUseCaseImpl(
        router,
        localStorage
    )

    @Provides
    @IntoMap
    @ClassKey(StartViewModel::class)
    fun provideStartViewModel(checkLocale: CheckLocaleUseCase) = StartViewModel(checkLocale)
}