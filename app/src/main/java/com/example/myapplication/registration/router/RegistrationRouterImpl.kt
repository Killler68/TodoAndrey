package com.example.myapplication.registration.router

import androidx.core.os.bundleOf
import com.example.myapplication.R
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.common.repository.User
import com.example.myapplication.common.string.USER_ID_KEY
import com.example.myapplication.registration.usecase.RegistrationRouter

class RegistrationRouterImpl : RegistrationRouter {

    override fun toNotes(user: User): NavCommand =
        NavCommand(
            R.id.action_fragmentRegistration_to_fragmentNotes,
            bundleOf(USER_ID_KEY to user.id)
        )
}