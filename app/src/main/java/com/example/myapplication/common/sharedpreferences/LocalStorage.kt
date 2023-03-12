package com.example.myapplication.common.sharedpreferences

interface LocalStorage {

    suspend fun isFirstLaunch(): Boolean
    suspend fun setFirstLaunch()
}