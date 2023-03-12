package com.example.myapplication.common.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.common.activity.viewmodel.ActivityViewModel
import com.example.myapplication.common.extensions.getViewModelFactory
import com.example.myapplication.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: ActivityViewModel by viewModels { getViewModelFactory() }
    private val navigator: Navigator = AppNavigator(this, R.id.background_main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.toRegistration()
    }

    override fun onResume() {
        super.onResume()
        viewModel.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeNavigator()
    }
}