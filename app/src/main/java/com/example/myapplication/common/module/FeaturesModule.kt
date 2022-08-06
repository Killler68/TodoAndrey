package com.example.myapplication.common.module

import com.example.myapplication.NotesModule
import com.example.myapplication.common.application.ApplicationModule
import dagger.Module


@Module(
    includes = [
        NotesModule::class,
        ApplicationModule::class
    ]
)
class FeaturesModule