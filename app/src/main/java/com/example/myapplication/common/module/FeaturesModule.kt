package com.example.myapplication.common.module

import com.example.myapplication.authorization.AuthorizationModule
import com.example.myapplication.common.activity.ActivityModule
import com.example.myapplication.common.application.ApplicationModule
import com.example.myapplication.common.database.DataBaseModule
import com.example.myapplication.common.navigation.NavigationModule
import com.example.myapplication.common.network.NetworkModule
import com.example.myapplication.common.repository.UserModule
import com.example.myapplication.common.sharedpreferences.LocalStorageModule
import com.example.myapplication.common.string.toast.ToastModule
import com.example.myapplication.common.usecase.AuthorizationNavigatorModule
import com.example.myapplication.common.usecase.BackNavigatorModule
import com.example.myapplication.common.usecase.RegistrationNavigatorModule
import com.example.myapplication.common.usecase.getuser.GetUserModule
import com.example.myapplication.featuresscreen.FeaturesScreenModule
import com.example.myapplication.notes.common.NoteModule
import com.example.myapplication.notes.note.NotesModule
import com.example.myapplication.notes.noteadd.NoteAddModule
import com.example.myapplication.profile.ProfileModule
import com.example.myapplication.registration.RegistrationModule
import com.example.myapplication.settings.SettingsModule
import com.example.myapplication.start.StartModule
import com.example.myapplication.weather.WeatherModule
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
        FeaturesScreenModule::class,
        BackNavigatorModule::class,
        ToastModule::class,
        RegistrationNavigatorModule::class,
        ToastModule::class,
        WelcomeModule::class,
        StartModule::class,
        LocalStorageModule::class,
        AuthorizationNavigatorModule::class,
        ProfileModule::class,
        GetUserModule::class,
        SettingsModule::class,
        NetworkModule::class,
        WeatherModule::class,
    ]
)
class FeaturesModule