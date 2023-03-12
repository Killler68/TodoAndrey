package com.example.myapplication.common.string.toast

import android.content.Context
import com.example.myapplication.common.string.toast.ToastFactory
import com.example.myapplication.common.string.toast.ToastFactoryImpl
import dagger.Module
import dagger.Provides

@Module
class ToastModule {

    @Provides
    fun provideToast(context: Context): ToastFactory = ToastFactoryImpl(context)

}