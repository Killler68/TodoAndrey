package com.example.myapplication.settings

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.usecase.BackNavigatorUseCase
import com.example.myapplication.settings.viewmodel.SettingsViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class SettingsModule {


    @Provides
    @IntoMap
    @ClassKey(SettingsViewModel::class)
    fun provideSettingsViewModel(
        backNavigatorUseCase: BackNavigatorUseCase
    ): ViewModel = SettingsViewModel(
        backNavigatorUseCase
    )
}