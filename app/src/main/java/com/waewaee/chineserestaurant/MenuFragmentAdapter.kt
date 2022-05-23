package com.waewaee.chineserestaurant

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MenuFragmentAdapter(fm: FragmentManager): FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> FoodFragment.newInstance()
            1 -> DrinkFragment.newInstance()
            else -> FoodFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}