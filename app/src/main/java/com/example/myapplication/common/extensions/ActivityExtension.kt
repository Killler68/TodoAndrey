package com.example.myapplication.common.extensions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.common.context.appComponent

fun AppCompatActivity.navigateToFragmentActivity(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.background_main, fragment)
        .commit()

}

fun Activity.getViewModelFactory() =
    applicationContext.appComponent.getViewModelFactory()