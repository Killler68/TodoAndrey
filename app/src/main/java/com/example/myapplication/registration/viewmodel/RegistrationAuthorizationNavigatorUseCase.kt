package com.example.myapplication.registration.viewmodel

import com.example.myapplication.common.navigation.NavCommand

interface RegistrationAuthorizationNavigatorUseCase {

    operator fun invoke(): NavCommand
}