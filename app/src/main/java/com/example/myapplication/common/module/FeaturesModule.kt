package com.example.myapplication.common.module

import com.example.myapplication.authorization.AuthorizationModule
import com.example.myapplication.notes.note.NotesModule
import com.example.myapplication.common.application.ApplicationModule
import com.example.myapplication.common.database.DataBaseModule
import com.example.myapplication.notes.common.NoteModule
import com.example.myapplication.notes.common.repository.NotesRepositoryImpl
import com.example.myapplication.notes.noteadd.NoteAddModule
import com.example.myapplication.registration.RegistrationModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(
    includes = [
        NotesModule::class,
        ApplicationModule::class,
        AuthorizationModule::class,
        NoteAddModule::class,
        NoteModule::class,
        DataBaseModule::class,
        RegistrationModule::class
    ]
)
class FeaturesModule