package com.example.myapplication.common.repository

import com.example.myapplication.common.database.user.UserDao
import dagger.Module
import dagger.Provides


@Module
class UserModule {

    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepositoryImpl(userDao)
}