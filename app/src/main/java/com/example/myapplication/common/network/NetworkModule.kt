package com.example.myapplication.common.network

import com.example.myapplication.common.api.WEATHER_URL
import com.example.myapplication.common.api.WeatherApi
import com.example.myapplication.common.string.HOTELS_URL
import com.example.myapplication.hotels.remote.api.HotelsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    fun provideWeatherApi(
        @Named("Weather") retrofit: Retrofit
    ): WeatherApi =
        retrofit.create(WeatherApi::class.java)

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideHotelsApi(
        @Named("Hotels") retrofit: Retrofit
    ): HotelsApi =
        retrofit.create(HotelsApi::class.java)

    @Provides
    @Named("Weather")
    fun provideWeatherRetrofit(
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(WEATHER_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Named("Hotels")
    fun provideHotelsRetrofit(
        gsonConverterFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(HOTELS_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
}
