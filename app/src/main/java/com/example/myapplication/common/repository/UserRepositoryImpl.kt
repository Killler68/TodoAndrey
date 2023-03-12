package com.example.myapplication.common.repository

import com.example.myapplication.common.database.user.UserDao
import com.example.myapplication.common.database.user.tuples.CreateUserTuple
import com.example.myapplication.common.database.user.tuples.DeleteUserTuple
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {

    override suspend fun getUser(id: Int): User =
        withContext(Dispatchers.IO) {
            val user = userDao.getUserById(id)?.toUser()
            Timber.i("request user №$id: $user")
            user ?: throw Exception("User $id not found")
        }

    override suspend fun getUserByName(name: String): User =
        withContext(Dispatchers.IO) {
            val userByName = userDao.getUserByName(name)?.toUser()
            Timber.i("request user №$name: $userByName")
            userByName ?: throw Exception("User $name not found")
        }


    override suspend fun getUsers(): List<User> =
        withContext(Dispatchers.IO) {
            val users = userDao.getUsers()
            Timber.i("Users: ${users.toList()}")
            userDao.getUsers().map { it.toUser() }.toList()
        }


    override suspend fun createUser(name: String): User =
        withContext(Dispatchers.IO) {
            userDao.createUser(
                CreateUserTuple(
                    name = name
                )
            )
            val createdUser = userDao.getUsers().last().toUser()
            Timber.i("created user: $createdUser")
            createdUser
        }


    override suspend fun deleteUser(id: Int) =
        withContext(Dispatchers.IO) {
            Timber.i("user №$id removed")
            userDao.deleteUser(DeleteUserTuple(id))
        }
}