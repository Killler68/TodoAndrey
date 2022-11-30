package com.example.myapplication.registration.router

import com.example.myapplication.R
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.registration.usecase.RegistrationRouter

class RegistrationRouterImpl : RegistrationRouter {

    override fun toNotes(): NavCommand =
        NavCommand(R.id.action_fragmentRegistration_to_fragmentNotes)

}