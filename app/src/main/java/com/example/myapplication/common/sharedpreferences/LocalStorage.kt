package com.example.myapplication.common.sharedpreferences

interface LocalStorage {

    suspend fun setFirstLaunch()
    suspend fun isFirstLaunch(): Boolean
}