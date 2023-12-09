package com.ones.seputarindonesia.ui.detail.cnbcFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.ones.seputarindonesia.adapter.MERDEKASectionPagerAdapter
import com.ones.seputarindonesia.databinding.FragmentMerdekaMainBinding

class MERDEKAMainFragment : Fragment() {

    private lateinit var binding: FragmentMerdekaMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMerdekaMainBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()
    }

    private fun setUpViewPager() {

        val adapter = MERDEKASectionPagerAdapter(this)
        binding.vpNewsmerdeka.adapter = adapter

        TabLayoutMediator(binding.toptabs, binding.vpNewsmerdeka) { tab, position ->
            when (position) {
                0 -> tab.text = "Edukasi"
                1 -> tab.text = "Metro"
                2 -> tab.text = "Otomotif"
            }
        }.attach()


    }
}