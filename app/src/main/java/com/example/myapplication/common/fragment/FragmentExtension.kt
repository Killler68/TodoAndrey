package com.example.myapplication.common.fragment

import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.common.context.appComponent

fun Fragment.navigateToFragment(fragment: Fragment) {
    this.parentFragmentManager.beginTransaction()
        .replace(R.id.background_main, fragment, fragment.javaClass.simpleName)
        .addToBackStack(fragment.javaClass.simpleName)
        .commit()
}

fun Fragment.getViewModelFactory() =
    requireContext().applicationContext.appComponent.getViewModelFactory()