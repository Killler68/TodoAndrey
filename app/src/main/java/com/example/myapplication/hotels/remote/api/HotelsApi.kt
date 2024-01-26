package com.example.myapplication.hotels.remote.api

import com.example.myapplication.hotels.remote.api.dto.HotelDetailedResponse
import com.example.myapplication.hotels.remote.api.dto.HotelsResponse
import com.example.myapplication.common.string.HOTELS_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface HotelsApi {

    @GET("/iMofas/ios-android-test/master/0777.json")
    suspend fun getHotelsList(): List<HotelsResponse>

    @GET("/iMofas/ios-android-test/master/{id}.json")
    suspend fun getHotelDetailed(@Path("id") id: Int): HotelDetailedResponse

    companion object {
        fun create(): HotelsApi {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(HOTELS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(HotelsApi::class.java)
        }
    }
}