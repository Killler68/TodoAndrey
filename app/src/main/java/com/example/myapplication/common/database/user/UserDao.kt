package com.example.myapplication.common.database.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.common.database.user.models.UserData
import com.example.myapplication.common.database.user.tuples.CreateUserTuple
import com.example.myapplication.common.database.user.tuples.DeleteUserTuple

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    suspend fun getUsers(): Array<UserData>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getUserById(id: Int): UserData?

    @Query("SELECT * FROM users WHERE name = :name AND password = :password")
    suspend fun getUserByNameAndPassword(name: String, password: String): UserData?

    @Insert(entity = UserTable::class)
    suspend fun createUser(user: CreateUserTuple): Long

    @Delete(entity = UserTable::class)
    suspend fun deleteUser(user: DeleteUserTuple)
}