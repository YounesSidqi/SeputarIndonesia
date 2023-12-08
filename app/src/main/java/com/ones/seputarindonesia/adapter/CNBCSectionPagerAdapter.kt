package com.ones.seputarindonesia.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ones.seputarindonesia.ui.detail.cnbcFragment.CNBCMainFragment
import com.ones.seputarindonesia.ui.detail.cnbcFragment.MarketFragment
import com.ones.seputarindonesia.ui.detail.cnbcFragment.PolitikFragment
import com.ones.seputarindonesia.ui.detail.cnbcFragment.TerbaruFragment

class CNBCSectionPagerAdapter(fm: CNBCMainFragment): FragmentStateAdapter(fm){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TerbaruFragment()
            1 -> PolitikFragment()
            2 -> MarketFragment()
            else -> TerbaruFragment()
        }
    }
}