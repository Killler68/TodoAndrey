package com.example.myapplication.common.module

import com.example.myapplication.authorization.AuthorizationModule
import com.example.myapplication.common.activity.ActivityModule
import com.example.myapplication.common.application.ApplicationModule
import com.example.myapplication.common.database.DataBaseModule
import com.example.myapplication.common.navigation.NavigationModule
import com.example.myapplication.common.repository.UserModule
import com.example.myapplication.common.string.toast.ToastModule
import com.example.myapplication.common.usecase.BackNavigatorModule
import com.example.myapplication.common.usecase.RegistrationNavigatorModule
import com.example.myapplication.notes.common.NoteModule
import com.example.myapplication.notes.note.NotesModule
import com.example.myapplication.notes.noteadd.NoteAddModule
import com.example.myapplication.registration.RegistrationModule
import com.example.myapplication.user.UserScreenModule
import com.example.myapplication.welcome.WelcomeModule
import dagger.Module


@Module(
    includes = [
        ActivityModule::class,
        NavigationModule::class,
        NotesModule::class,
        ApplicationModule::class,
        AuthorizationModule::class,
        NoteAddModule::class,
        NoteModule::class,
        DataBaseModule::class,
        RegistrationModule::class,
        UserModule::class,
        UserScreenModule::class,
        BackNavigatorModule::class,
        ToastModule::class,
        RegistrationNavigatorModule::class,
        WelcomeModule::class
    ]
)
class FeaturesModule