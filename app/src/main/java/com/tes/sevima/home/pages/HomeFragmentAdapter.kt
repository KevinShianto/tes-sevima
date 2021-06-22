package com.tes.sevima.home.pages

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.tes.sevima.home.pages.chat.ChatFragment
import com.tes.sevima.home.pages.classes.ClassesFragment
import com.tes.sevima.home.pages.explore.ExploreFragment
import com.tes.sevima.home.pages.home.HomeFragment
import com.tes.sevima.home.pages.other.OtherFragment

class HomeFragmentAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

    private val pages = listOf(
        HomeFragment(),
        ClassesFragment(),
        ChatFragment(),
        ExploreFragment(),
        OtherFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Home"
            1 -> "Class"
            2 -> "Chat"
            3 -> "Explore"
            else -> "Other"
        }
    }
}