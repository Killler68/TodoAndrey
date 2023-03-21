package com.example.myapplication.weather

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.api.WeatherApi
import com.example.myapplication.weather.repository.WeatherRepositoryImpl
import com.example.myapplication.weather.usecase.WeatherPreviewUseCaseImpl
import com.example.myapplication.weather.usecase.WeatherRepository
import com.example.myapplication.weather.viewmodel.WeatherPreviewUseCase
import com.example.myapplication.weather.viewmodel.WeatherViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class WeatherModule {

    @Provides
    fun provideWeatherRepository(weatherApi: WeatherApi): WeatherRepository =
        WeatherRepositoryImpl(weatherApi)

    @Provides
    fun provideWeatherPreviewUseCase(weatherRepository: WeatherRepository): WeatherPreviewUseCase =
        WeatherPreviewUseCaseImpl(weatherRepository)

    @Provides
    @IntoMap
    @ClassKey(WeatherViewModel::class)
    fun provideWeatherViewModel(
        getWeatherPreview: WeatherPreviewUseCase
    ): ViewModel = WeatherViewModel(
        getWeatherPreview
    )
}