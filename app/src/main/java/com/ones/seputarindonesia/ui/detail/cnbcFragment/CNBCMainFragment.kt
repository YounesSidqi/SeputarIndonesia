package com.ones.seputarindonesia.ui.detail.cnbcFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.ones.seputarindonesia.adapter.CNBCSectionPagerAdapter
import com.ones.seputarindonesia.databinding.FragmentCnbcMainBinding

class CNBCMainFragment : Fragment() {

    private lateinit var binding: FragmentCnbcMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCnbcMainBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
    }

    private fun setUpViewPager() {

        val adapter = CNBCSectionPagerAdapter(this)
        binding.vpNewscnbc.adapter = adapter

        TabLayoutMediator(binding.toptabs, binding.vpNewscnbc) { tab, position ->
            when (position) {
                0 -> tab.text = "Terbaru"
                1 -> tab.text = "Jakarta"
                2 -> tab.text = "Market"
            }
        }.attach()


    }
}