package com.example.myapplication.user.pager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.user.pager.FeaturesFragment

class FeaturesAdapter(
    private val features: List<Int>,
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = features.count()

    override fun createFragment(position: Int): Fragment =
        FeaturesFragment.create(features[position])
}