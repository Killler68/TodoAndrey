package com.example.myapplication.common.resources

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes resId: Int, vararg args: Any): String
}