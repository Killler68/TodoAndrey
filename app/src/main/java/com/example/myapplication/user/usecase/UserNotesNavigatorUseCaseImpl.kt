package com.example.myapplication.user.usecase

import com.example.myapplication.common.navigation.NavCommand
import com.example.myapplication.user.viemodel.UserNotesNavigatorUseCase

class UserNotesNavigatorUseCaseImpl(private val router: UserRouter) :
    UserNotesNavigatorUseCase {

    override fun invoke(): NavCommand = router.toNotes()
}