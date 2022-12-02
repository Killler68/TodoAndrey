package com.example.myapplication.registration.usecase

import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.User

interface RegistrationRouter {

    fun toNotes(user: User): NavCommand
}