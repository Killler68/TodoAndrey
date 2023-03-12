package com.example.myapplication.user

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.user.pager.repository.FeaturesRepositoryImpl
import com.example.myapplication.user.pager.usecase.FeatureUseCaseImpl
import com.example.myapplication.user.pager.usecase.FeaturesRepository
import com.example.myapplication.user.pager.usecase.FeaturesUseCaseImpl
import com.example.myapplication.user.usecase.GetUserImpl
import com.example.myapplication.user.usecase.NotesNavigatorUseCaseImpl
import com.example.myapplication.user.viemodel.*
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class UserScreenModule {

    @Provides
    fun provideNotesNavigatorUseCase(router: Router): NotesNavigatorUseCase =
        NotesNavigatorUseCaseImpl(router)

    @Provides
    fun provideGetUser(userRepository: UserRepository): GetUser = GetUserImpl(userRepository)

    @Provides
    fun provideFeaturesRepository(): FeaturesRepository = FeaturesRepositoryImpl()

    @Provides
    fun provideFeaturesUseCase(repository: FeaturesRepository): FeaturesUseCase =
        FeaturesUseCaseImpl(repository)

    @Provides
    fun provideFeatureUseCase(repository: FeaturesRepository): FeatureUseCase =
        FeatureUseCaseImpl(repository)

    @Provides
    @IntoMap
    @ClassKey(UserViewModel::class)
    fun provideUserViewModel(
        featureUseCase: FeatureUseCase,
        featuresUseCase: FeaturesUseCase,
        getUserUseCase: GetUser,
        navigateToNotesUseCase: NotesNavigatorUseCase
    ): ViewModel =
        UserViewModel(
            featureUseCase,
            featuresUseCase,
            getUserUseCase,
            navigateToNotesUseCase
        )
}