package com.example.myapplication.user.router

import com.example.myapplication.R
import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.user.usecase.UserRouter

class UserRouterImpl : UserRouter {

    override fun toNotes(): NavCommand =
        NavCommand(R.id.action_fragmentUser_to_fragmentNotes)
}