package com.example.myapplication.authorization.router

import com.example.myapplication.R
import com.example.myapplication.authorization.usecase.AuthorizationRouter
import com.example.myapplication.common.navigation.NavCommand

class AuthorizationRouterImpl : AuthorizationRouter {

    override fun toNotes(): NavCommand =
        NavCommand(R.id.action_fragmentAuthorization_to_fragmentNotes)
}