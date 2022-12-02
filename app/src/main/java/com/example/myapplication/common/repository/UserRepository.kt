package com.example.myapplication.common.repository

interface UserRepository {

    suspend fun getUser(id: Int): User
    suspend fun getUsers(): List<User>
    suspend fun createUser(name: String): User
    suspend fun deleteUser(id: Int)
}