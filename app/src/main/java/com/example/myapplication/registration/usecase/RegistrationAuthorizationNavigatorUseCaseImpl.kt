package com.example.myapplication.registration.usecase

import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.registration.viewmodel.RegistrationAuthorizationNavigatorUseCase

class RegistrationAuthorizationNavigatorUseCaseImpl(private val router: RegistrationRouter) :
    RegistrationAuthorizationNavigatorUseCase {

    override fun invoke(): NavCommand = router.toNotes()
}