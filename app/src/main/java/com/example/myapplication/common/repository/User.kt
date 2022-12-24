package com.example.myapplication.common.repository

import com.example.myapplication.common.database.user.models.UserData

data class User(
    val id: Int,
    val name: String
)

val emptyUser = User(
    0, ""
)

fun UserData.toUser() = User(
    id, name
)