package com.ones.seputarindonesia.ui.detail.cnbcFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.ones.seputarindonesia.adapter.CNNSectionPagerAdapter
import com.ones.seputarindonesia.databinding.FragmentCnnMainBinding

class CNNMainFragment : Fragment() {

    private lateinit var binding: FragmentCnnMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCnnMainBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
    }

    private fun setUpViewPager() {

        val adapter = CNNSectionPagerAdapter(this)
        binding.vpNewscnn.adapter = adapter

        TabLayoutMediator(binding.toptabs, binding.vpNewscnn) { tab, position ->
            when (position) {
                0 -> tab.text = "Terbaru"
                1 -> tab.text = "Nasional"
                2 -> tab.text = "Internasional"
            }
        }.attach()


    }
}