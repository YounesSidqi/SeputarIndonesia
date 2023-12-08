package com.ones.seputarindonesia.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ones.seputarindonesia.ui.detail.cnbcFragment.MERDEKAMainFragment
import com.ones.seputarindonesia.ui.detail.cnnFragment.DuniaFragment
import com.ones.seputarindonesia.ui.detail.cnnFragment.JakartaFragment
import com.ones.seputarindonesia.ui.detail.cnnFragment.OlahragaFragment

class MERDEKASectionPagerAdapter(fm: MERDEKAMainFragment): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> DuniaFragment()
            1 -> JakartaFragment()
            2 -> OlahragaFragment()
            else -> DuniaFragment()
        }
    }
}