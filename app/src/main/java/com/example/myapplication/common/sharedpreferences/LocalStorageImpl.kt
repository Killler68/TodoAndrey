package com.example.myapplication.common.sharedpreferences

import android.content.Context
import com.example.myapplication.common.string.FIRST_LAUNCH_APP_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class LocalStorageImpl(
    private val context: Context
) : LocalStorage {

    override suspend fun isFirstLaunch(): Boolean = withContext(Dispatchers.IO) {
        val sharedPreferences =
            context.getSharedPreferences(FIRST_LAUNCH_APP_KEY, Context.MODE_PRIVATE)
        sharedPreferences.getBoolean(FIRST_LAUNCH_APP_KEY, true)
    }

    override suspend fun setFirstLaunch() = withContext(Dispatchers.IO) {
        Timber.i("Set first launch")
        val sharedPreferences =
            context.getSharedPreferences(FIRST_LAUNCH_APP_KEY, Context.MODE_PRIVATE)
        sharedPreferences.edit()
            .putBoolean(FIRST_LAUNCH_APP_KEY, false)
            .apply()
    }
}