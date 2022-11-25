package com.example.myapplication.authorization.usecase

import com.example.myapplication.common.navigation.NavCommand

interface AuthorizationRouter {

    fun toNotes(): NavCommand
}