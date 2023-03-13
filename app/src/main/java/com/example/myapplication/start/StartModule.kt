package com.example.myapplication.start

import androidx.lifecycle.ViewModel
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
        localStorage: LocalStorage,
        router: Router
    ): CheckLocaleUseCase = CheckLocaleUseCaseImpl(
        localStorage,
        router
    )

    @Provides
    @IntoMap
    @ClassKey(StartViewModel::class)
    fun provideStartViewModel(
        checkLocaleUseCase: CheckLocaleUseCase
    ): ViewModel =
        StartViewModel(
            checkLocaleUseCase
        )
}