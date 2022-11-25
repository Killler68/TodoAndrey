package com.example.myapplication.authorization.viewmodel

import com.example.myapplication.common.navigation.NavCommand

interface AuthorizationNotesNavigatorUseCase {

    operator fun invoke(): NavCommand
}
