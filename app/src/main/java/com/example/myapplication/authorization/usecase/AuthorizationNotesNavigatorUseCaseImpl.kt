package com.example.myapplication.authorization.usecase

import com.example.myapplication.authorization.viewmodel.AuthorizationNotesNavigatorUseCase
import com.example.myapplication.common.navigation.NavCommand

class AuthorizationNotesNavigatorUseCaseImpl(private val router: AuthorizationRouter) :
    AuthorizationNotesNavigatorUseCase {

    override fun invoke(): NavCommand = router.toNotes()
}