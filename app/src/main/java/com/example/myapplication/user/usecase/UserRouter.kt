package com.example.myapplication.user.usecase

import com.example.myapplication.common.navigation.NavCommand

interface UserRouter {

    fun toNotes(): NavCommand
}