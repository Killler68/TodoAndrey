package com.example.myapplication.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Provider


@Module
class ViewModelModule {
    @Provides
    fun provideViewModelFactory(
        viewModelProviders: MutableMap<Class<*>, Provider<ViewModel>>
    ): ViewModelProvider.Factory = CommonViewModelFactory(viewModelProviders)

}