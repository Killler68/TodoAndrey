package com.example.myapplication.hotels.remote

import com.example.myapplication.common.string.HOTELS_URL
import com.example.myapplication.hotels.remote.api.HotelsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class HotelsNetworkModule {
//
//    @Provides
//    fun provideHotelsApi(retrofit: Retrofit): HotelsApi = retrofit.create(HotelsApi::class.java)
//
//    @Provides
//    fun provideRetrofit(
//        gsonConverterFactory: GsonConverterFactory,
//    ): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(HOTELS_URL)
//            .addConverterFactory(gsonConverterFactory)
//            .build()
//    }
}
