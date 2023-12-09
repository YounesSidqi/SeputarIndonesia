package com.ones.seputarindonesia.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ones.seputarindonesia.data.repository.NewsRepository

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {
    val terbaruNews : LiveData<NewsResponse> = repository.terbaruNews
    val politikNews: LiveData<NewsResponse> = repository.politikNews
    val marketNews: LiveData<NewsResponse> = repository.marketNews
    val CNNTerbaruNews: LiveData<NewsResponse> = repository.CNNTerbaruNews
    val CNNNasional: LiveData<NewsResponse> = repository.CNNNasionalNews
    val CNNInternasional: LiveData<NewsResponse> = repository.CNNInternasionalNews
    val MERDEKADunia: LiveData<NewsResponse> = repository.MERDEKADunisNews
    val MERDEKAJakarta: LiveData<NewsResponse> = repository.MERDEKAJakartaNews
    val MERDEKAOlahraga: LiveData<NewsResponse> = repository.MERDEKAOlahraga
    val searchNews: LiveData<NewsResponse> = repository.searchNews
    val isLoading: LiveData<Boolean> = repository.isLoading

    fun getTerbaruNews() {
        repository.getTerbaruNews()
    }


    fun getPolitikNews() {
        repository.getPolitikNews()
    }


    fun getMarketNews() {
        repository.getMarketNews()
    }

    // Fungsi untuk mendapatkan berita CNNTerbaruNews
    fun getCNNTerbaruNews() {
        repository.getCNNTerbaruNews()
    }

    // Fungsi untuk mendapatkan berita CNNNasional
    fun getCNNNasionalNews() {
        repository.getCNNNasionalNews()
    }

    // Fungsi untuk mendapatkan berita CNNInternasional
    fun getCNNInternasionalNews() {
        repository.getCNNInternasionalNews()
    }

    // Fungsi untuk mendapatkan berita MERDEKADunia
    fun getMERDEKADuniaNews() {
        repository.getMERDEKADuniaNews()
    }

    // Fungsi untuk mendapatkan berita MERDEKAJakarta
    fun getMERDEKAJakartaNews() {
        repository.getMERDEKAJakartaNews()
    }

    // Fungsi untuk mendapatkan berita MERDEKAOlahraga
    fun getMERDEKAOlahragaNews() {
        repository.getMERDEKAOlahragaNews()
    }

}