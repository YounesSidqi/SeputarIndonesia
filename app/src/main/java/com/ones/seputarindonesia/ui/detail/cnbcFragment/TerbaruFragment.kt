package com.ones.seputarindonesia.ui.detail.cnbcFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ones.seputarindonesia.adapter.NewsAdapter
import com.ones.seputarindonesia.data.model.NewsViewModel
import com.ones.seputarindonesia.data.repository.NewsRepository
import com.ones.seputarindonesia.databinding.FragmentTerbaruCnbcBinding
import com.ones.seputarindonesia.utils.NewsViewModelFactory

class TerbaruFragment : Fragment() {

    private lateinit var binding: FragmentTerbaruCnbcBinding
    private val terbaruViewModel: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTerbaruCnbcBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = NewsAdapter()
        terbaruViewModel.getTerbaruNews()
        terbaruViewModel.terbaruNews.observe(viewLifecycleOwner){
                dataNews -> mAdapter.setData(dataNews.data?.articles)
            binding.rvTerbarucnbcNews.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }



        terbaruViewModel.isLoading.observe(viewLifecycleOwner){
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