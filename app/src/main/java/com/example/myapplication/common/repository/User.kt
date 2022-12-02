package com.example.myapplication.common.repository

import com.example.myapplication.common.database.user.models.UserData

data class User(
    val id: Int,
    val name: String
)

val emptyList = User(
    0, ""
)

fun UserData.toUser() = User(
    id, name
)