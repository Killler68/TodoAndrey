package com.example.myapplication.common.resources

import android.content.Context
import com.example.myapplication.common.resources.ResourceManager

class ResourceManagerImpl(
    private val context: Context
) : ResourceManager {

    override fun getString(resId: Int, vararg args: Any): String =
        context.resources.getString(resId, *args)
}