package com.example.myapplication.common.activity.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.common.navigation.Screens
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router

class ActivityViewModel(
    private val router: Router,
    private val navigatorHolder: NavigatorHolder
) : ViewModel() {


    fun toStart() = router.navigateTo(Screens.toStart())

    fun setNavigator(navigator: Navigator) = navigatorHolder.setNavigator(navigator)

    fun removeNavigator() = navigatorHolder.removeNavigator()
}