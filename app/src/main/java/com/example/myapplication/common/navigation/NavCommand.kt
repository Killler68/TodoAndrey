package com.example.myapplication.common.navigation

import android.os.Bundle
import androidx.core.os.bundleOf

data class NavCommand(
    val action: Int,
    val command: Bundle = bundleOf()
)