package com.example.myapplication.common.application

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.common.module.FeaturesModule
import com.example.myapplication.common.sharedpreferences.LocalStorage
import com.example.myapplication.common.viewmodel.ViewModelModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        FeaturesModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun getViewModelFactory(): ViewModelProvider.Factory
    fun getLocalStorage(): LocalStorage

}