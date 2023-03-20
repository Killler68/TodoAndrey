package com.example.myapplication.user

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.repository.UserRepository
import com.example.myapplication.common.usecase.AuthorizationNavigatorUseCase
import com.example.myapplication.common.usecase.getuser.GetUserUseCase
import com.example.myapplication.user.pager.repository.FeaturesRepositoryImpl
import com.example.myapplication.user.pager.usecase.*
import com.example.myapplication.user.pager.viewmodel.FeaturesPagerNavigatorUseCase
import com.example.myapplication.user.pager.viewmodel.FeaturesViewModel
import com.example.myapplication.user.pager.viewmodel.NotesNavigatorUseCase
import com.example.myapplication.user.usecase.DeleteUserUseCaseImpl
import com.example.myapplication.user.usecase.ProfileNavigatorUseCaseImpl
import com.example.myapplication.user.viewmodel.*
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class FeaturesScreenModule {

    @Provides
    fun provideNotesNavigatorUseCase(router: Router): NotesNavigatorUseCase =
        NotesNavigatorUseCaseImpl(router)

    @Provides
    fun provideFeaturesRepository(): FeaturesRepository = FeaturesRepositoryImpl()

    @Provides
    fun provideFeaturesUseCase(repository: FeaturesRepository): FeaturesUseCase =
        FeaturesUseCaseImpl(repository)

    @Provides
    fun provideFeatureUseCase(repository: FeaturesRepository): FeatureUseCase =
        FeatureUseCaseImpl(repository)

    @Provides
    fun provideProfileNavigatorUseCase(router: Router): ProfileNavigatorUseCase =
        ProfileNavigatorUseCaseImpl(router)

    @Provides
    fun provideDeleteUserUseCase(
        repository: UserRepository,
        router: Router
    ): DeleteUserUseCase =
        DeleteUserUseCaseImpl(
            repository,
            router
        )

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
    @ClassKey(FeaturesScreenViewModel::class)
    fun provideFeaturesScreenViewModel(
        featuresUseCase: FeaturesUseCase,
        getUserUseCase: GetUserUseCase,
        deleteUserUseCase: DeleteUserUseCase,
        navigatorToAuthorizationUseCase: AuthorizationNavigatorUseCase,
        navigatorToProfile: ProfileNavigatorUseCase
    ): ViewModel =
        FeaturesScreenViewModel(
            featuresUseCase,
            getUserUseCase,
            deleteUserUseCase,
            navigatorToAuthorizationUseCase,
            navigatorToProfile
        )
}