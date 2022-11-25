package com.example.myapplication.common.module

import com.example.myapplication.authorization.AuthorizationModule
import com.example.myapplication.notes.NotesModule
import com.example.myapplication.common.application.ApplicationModule
import dagger.Module


@Module(
    includes = [
        NotesModule::class,
        ApplicationModule::class,
        AuthorizationModule::class
    ]
)
class FeaturesModule