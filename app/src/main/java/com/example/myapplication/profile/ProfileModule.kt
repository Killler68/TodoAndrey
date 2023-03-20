package com.example.myapplication.profile

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.usecase.BackNavigatorUseCase
import com.example.myapplication.common.usecase.getuser.GetUserUseCase
import com.example.myapplication.profile.viewmodel.ProfileViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ProfileModule {

    @Provides
    @IntoMap
    @ClassKey(ProfileViewModel::class)
    fun provideProfileViewModel(
        getUserUseCase: GetUserUseCase,
        backNavigatorUseCase: BackNavigatorUseCase
    ): ViewModel = ProfileViewModel(
        getUserUseCase,
        backNavigatorUseCase
    )
}