package com.example.myapplication.featuresscreen.pager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.featuresscreen.pager.FeaturesFragment

class FeaturesAdapter(
    private val features: List<Int>,
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = features.count()

    override fun createFragment(position: Int): Fragment =
        FeaturesFragment.create(features[position])
}