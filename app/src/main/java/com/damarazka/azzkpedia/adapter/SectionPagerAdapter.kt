package com.damarazka.azzkpedia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.damarazka.azzkpedia.fragment.AboutDailyFragment
import com.damarazka.azzkpedia.fragment.AboutSportFragment
import com.damarazka.azzkpedia.fragment.AboutWarningFragment
import com.damarazka.azzkpedia.fragment.CommonFragment

class SectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 4
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CommonFragment()
            1 -> AboutDailyFragment()
            2 -> AboutSportFragment()
            3 -> AboutWarningFragment()
            else -> CommonFragment()
        }
    }
}