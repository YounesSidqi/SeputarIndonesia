package com.ones.seputarindonesia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ones.seputarindonesia.ui.detail.cnbcFragment.CNBCMainFragment
import com.ones.seputarindonesia.ui.detail.cnbcFragment.CNNMainFragment
import com.ones.seputarindonesia.ui.detail.cnbcFragment.MERDEKAMainFragment
import com.ones.seputarindonesia.ui.detail.cnbcFragment.MarketFragment
import com.ones.seputarindonesia.ui.detail.cnnFragment.DuniaFragment
import com.ones.seputarindonesia.ui.detail.cnnFragment.JakartaFragment
import com.ones.seputarindonesia.ui.detail.cnnFragment.OlahragaFragment

class SectionPagerAdapter (fm : FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CNBCMainFragment()
            1 -> CNNMainFragment()
            2 -> MERDEKAMainFragment()
            else -> DuniaFragment()
        }
    }
}