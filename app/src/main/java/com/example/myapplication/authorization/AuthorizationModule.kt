package com.example.myapplication.authorization

import androidx.lifecycle.ViewModel
import com.example.myapplication.authorization.router.AuthorizationRouterImpl
import com.example.myapplication.authorization.usecase.AuthorizationNotesNavigatorUseCaseImpl
import com.example.myapplication.authorization.usecase.AuthorizationRouter
import com.example.myapplication.authorization.viewmodel.AuthorizationNotesNavigatorUseCase
import com.example.myapplication.authorization.viewmodel.AuthorizationViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class AuthorizationModule {

    @Provides
    fun provideAuthorizationRouter(): AuthorizationRouter = AuthorizationRouterImpl()

    @Provides
    fun provideAuthorizationNotesNavigatorUseCase(router: AuthorizationRouter):
            AuthorizationNotesNavigatorUseCase =
        AuthorizationNotesNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(AuthorizationViewModel::class)
    fun provideAuthorizationViewModel(
        navigateToNotesUseCase: AuthorizationNotesNavigatorUseCase
    ): ViewModel =
        AuthorizationViewModel(
            navigateToNotesUseCase
        )
}