package com.example.myapplication.user.viemodel

import com.example.myapplication.common.navigation.NavCommand

interface UserNotesNavigatorUseCase {

    operator fun invoke(): NavCommand
}
