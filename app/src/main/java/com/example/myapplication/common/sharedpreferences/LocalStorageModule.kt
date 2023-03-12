package com.example.myapplication.common.sharedpreferences

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class LocalStorageModule {

    @Provides
    fun provideLocalStorage(context: Context): LocalStorage = LocalStorageImpl(context)
}