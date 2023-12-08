package com.ones.seputarindonesia.ui.detail.cnnFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ones.seputarindonesia.R
import com.ones.seputarindonesia.adapter.NewsAdapter
import com.ones.seputarindonesia.data.model.NewsViewModel
import com.ones.seputarindonesia.data.repository.NewsRepository
import com.ones.seputarindonesia.databinding.FragmentDuniaMerdekaBinding
import com.ones.seputarindonesia.databinding.FragmentNasionalCnnBinding
import com.ones.seputarindonesia.databinding.FragmentPolitikCnbcBinding
import com.ones.seputarindonesia.utils.NewsViewModelFactory

class DuniaFragment : Fragment() {

    private lateinit var binding: FragmentDuniaMerdekaBinding
    private val commonViewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDuniaMerdekaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = NewsAdapter()
        commonViewModel.getMERDEKADuniaNews()
        commonViewModel.MERDEKADunia.observe(viewLifecycleOwner){
                dataNews -> mAdapter.setData(dataNews.data?.articles)
            binding.rvDuniaNews.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }



        commonViewModel.isLoading.observe(viewLifecycleOwner){
            isLoading(it)
        }
    }

    private fun isLoading(isLoading: Boolean) {
        if (isLoading){
            binding.loadingView.root.visibility = View.VISIBLE

        }else{
            binding.loadingView.root.visibility = View.GONE
        }
    }


}