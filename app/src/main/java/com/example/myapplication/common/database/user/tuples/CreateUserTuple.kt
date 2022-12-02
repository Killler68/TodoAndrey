package com.example.myapplication.common.database.user.tuples

data class CreateUserTuple(
    val name: String
)

data class DeleteUserTuple(val id: Int)