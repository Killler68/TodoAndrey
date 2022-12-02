package com.example.myapplication.user.pager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.user.pager.FragmentFeatures

class FeaturesAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val items = mutableListOf<Int>()

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun createFragment(position: Int): Fragment {
        return FragmentFeatures.create(items[position])
    }

    fun setItems(item: List<Int>) {
        items.addAll(item)
    }
}