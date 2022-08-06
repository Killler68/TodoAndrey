package com.example.myapplication.common.context

import android.content.Context
import com.example.myapplication.common.application.AppComponent
import com.example.myapplication.common.application.MainApp

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }