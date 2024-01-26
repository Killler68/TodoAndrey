package com.example.myapplication.common.resources

import android.content.Context
import com.example.myapplication.common.resources.ResourceManager
import com.example.myapplication.common.resources.ResourceManagerImpl
import dagger.Module
import dagger.Provides

@Module
class ResourcesModule {

    @Provides
    fun provideResourceManager(
        context: Context
    ): ResourceManager =
        ResourceManagerImpl(
            context
        )
}