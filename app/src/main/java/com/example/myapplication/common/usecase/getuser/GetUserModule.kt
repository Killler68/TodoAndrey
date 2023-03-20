package com.example.myapplication.common.usecase.getuser

import com.example.myapplication.common.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class GetUserModule {

    @Provides
    fun provideGetUser(userRepository: UserRepository): GetUserUseCase = GetUserUseCaseImpl(userRepository)
}