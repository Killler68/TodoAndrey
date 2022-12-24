package com.example.myapplication.user.viemodel

import com.example.myapplication.common.repository.User

interface GetUser {

    suspend operator fun invoke(id: Int): User
}