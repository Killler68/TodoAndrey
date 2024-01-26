package com.example.myapplication.hotels.hotellist

import androidx.lifecycle.ViewModel
import com.example.myapplication.hotels.remote.api.HotelsApi
import com.example.myapplication.hotels.hoteldetailed.usecase.HotelDetailedRepository
import com.example.myapplication.hotels.hotellist.repository.HotelListRepositoryImpl
import com.example.myapplication.hotels.hotellist.usecase.HotelsAndDetailedUseCaseImpl
import com.example.myapplication.hotels.hotellist.usecase.HotelDetailedNavigatorUseCaseImpl
import com.example.myapplication.hotels.hotellist.usecase.HotelListRepository
import com.example.myapplication.hotels.hotellist.viewmodel.HotelsAndDetailedUseCase
import com.example.myapplication.hotels.hotellist.viewmodel.HotelDetailedNavigatorUseCase
import com.example.myapplication.hotels.hotellist.viewmodel.HotelListViewModel
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class HotelListModule {

    @Provides
    fun provideHotelListRepository(
        hotelsApi: HotelsApi
    ): HotelListRepository = HotelListRepositoryImpl(
        hotelsApi
    )

    @Provides
    fun provideHotelsAndDetailedUseCase(
        hotelListRepository: HotelListRepository,
        hotelDetailedRepository: HotelDetailedRepository
    ): HotelsAndDetailedUseCase = HotelsAndDetailedUseCaseImpl(
        hotelListRepository,
        hotelDetailedRepository
    )

    @Provides
    fun provideHotelDetailedNavigatorUseCase(
        router: Router
    ): HotelDetailedNavigatorUseCase = HotelDetailedNavigatorUseCaseImpl(
        router
    )

    @Provides
    @IntoMap
    @ClassKey(HotelListViewModel::class)
    fun provideHotelListViewModel(
        hotelsAndDetailedUseCase: HotelsAndDetailedUseCase,
        navigatorToHotelDetailedUseCase: HotelDetailedNavigatorUseCase
    ): ViewModel = HotelListViewModel(
        hotelsAndDetailedUseCase,
        navigatorToHotelDetailedUseCase
    )
}