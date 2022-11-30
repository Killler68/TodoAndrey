package com.example.myapplication.registration

import androidx.lifecycle.ViewModel
import com.example.myapplication.registration.router.RegistrationRouterImpl
import com.example.myapplication.registration.usecase.RegistrationAuthorizationNavigatorUseCaseImpl
import com.example.myapplication.registration.usecase.RegistrationRouter
import com.example.myapplication.registration.viewmodel.RegistrationAuthorizationNavigatorUseCase
import com.example.myapplication.registration.viewmodel.RegistrationViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class RegistrationModule {

    @Provides
    fun provideRegistrationRouter(): RegistrationRouter = RegistrationRouterImpl()

    @Provides
    fun provideRegistrationAuthorizationNavigatorUseCase(router: RegistrationRouter):
            RegistrationAuthorizationNavigatorUseCase =
        RegistrationAuthorizationNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(RegistrationViewModel::class)
    fun provideRegistrationViewModel(
        navigateToNotesUseCase: RegistrationAuthorizationNavigatorUseCase
    ): ViewModel =
        RegistrationViewModel(
            navigateToNotesUseCase
        )
}