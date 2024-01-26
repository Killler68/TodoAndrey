package com.example.myapplication.hotels.hoteldetailed

import androidx.lifecycle.ViewModel
import com.example.myapplication.hotels.remote.api.HotelsApi
import com.example.myapplication.hotels.hoteldetailed.repository.HotelDetailedRepositoryImpl
import com.example.myapplication.hotels.hoteldetailed.usecase.BackNavigatorUseCaseImpl
import com.example.myapplication.hotels.hoteldetailed.usecase.HotelDetailedRepository
import com.example.myapplication.hotels.hoteldetailed.usecase.HotelDetailedUseCaseImpl
import com.example.myapplication.hotels.hoteldetailed.viewmodel.BackNavigatorUseCase
import com.example.myapplication.hotels.hoteldetailed.viewmodel.HotelDetailedUseCase
import com.example.myapplication.hotels.hoteldetailed.viewmodel.HotelDetailedViewModel
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class HotelDetailedModule {

    @Provides
    fun provideHotelDetailedRepository(
        hotelsApi: HotelsApi
    ): HotelDetailedRepository = HotelDetailedRepositoryImpl(
        hotelsApi
    )

    @Provides
    fun provideHotelDetailedUseCase(
        hotelDetailedRepository: HotelDetailedRepository
    ): HotelDetailedUseCase = HotelDetailedUseCaseImpl(
        hotelDetailedRepository
    )

    @Provides
    fun provideBackNavigatorUseCase(
        router: Router
    ): BackNavigatorUseCase = BackNavigatorUseCaseImpl(
        router
    )

    @Provides
    @IntoMap
    @ClassKey(HotelDetailedViewModel::class)
    fun provideHotelDetailedViewModel(
        hotelDetailedUseCase: HotelDetailedUseCase,
        backNavigatorUseCase: BackNavigatorUseCase
    ): ViewModel = HotelDetailedViewModel(
        hotelDetailedUseCase,
        backNavigatorUseCase
    )
}