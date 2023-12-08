package com.ones.seputarindonesia.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ones.seputarindonesia.ui.detail.cnbcFragment.CNNMainFragment
import com.ones.seputarindonesia.ui.detail.cnnFragment.InternasionalFragment
import com.ones.seputarindonesia.ui.detail.cnnFragment.NasionalFragment
import com.ones.seputarindonesia.ui.detail.cnnFragment.TerbaruFragment

class CNNSectionPagerAdapter(fm: CNNMainFragment): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TerbaruFragment()
            1 -> NasionalFragment()
            2 -> InternasionalFragment()
            else -> TerbaruFragment()
        }
    }
}