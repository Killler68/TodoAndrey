package com.example.myapplication.user

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.user.pager.repository.FeaturesRepositoryImpl
import com.example.myapplication.user.pager.usecase.*
import com.example.myapplication.user.pager.viewmodel.FeaturesPagerNavigatorUseCase
import com.example.myapplication.user.pager.viewmodel.FeaturesViewModel
import com.example.myapplication.user.pager.viewmodel.NotesNavigatorUseCase
import com.example.myapplication.user.usecase.GetUserImpl
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
    fun provideFeaturesPagerNavigatorUseCase(
        router: Router,
        repository: FeaturesRepository
    ): FeaturesPagerNavigatorUseCase =
        FeaturesPagerNavigatorUseCaseImpl(
            router,
            repository
        )

    @Provides
    @IntoMap
    @ClassKey(FeaturesViewModel::class)
    fun provideFeaturesViewModel(
        getFeature: FeatureUseCase,
        navigatorToFeatureUseCase: FeaturesPagerNavigatorUseCase
    ): ViewModel = FeaturesViewModel(
        getFeature,
        navigatorToFeatureUseCase
    )

    @Provides
    @IntoMap
    @ClassKey(UserViewModel::class)
    fun provideUserViewModel(
        featuresUseCase: FeaturesUseCase,
        getUserUseCase: GetUser
    ): ViewModel =
        UserViewModel(
            featuresUseCase,
            getUserUseCase
        )
}