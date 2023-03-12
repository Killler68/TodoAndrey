package com.example.myapplication.common.navigation

import com.example.myapplication.registration.RegistrationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun toRegistration() = FragmentScreen { RegistrationFragment() }

}