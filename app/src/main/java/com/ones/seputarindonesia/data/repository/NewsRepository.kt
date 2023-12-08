package com.ones.seputarindonesia.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ones.seputarindonesia.data.model.NewsResponse
import com.ones.seputarindonesia.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    private val _terbaruNews = MutableLiveData<NewsResponse>()
    val terbaruNews: LiveData<NewsResponse> = _terbaruNews

    private val _politikNews = MutableLiveData<NewsResponse>()
    val politikNews: LiveData<NewsResponse> = _politikNews

    private val _marketNews = MutableLiveData<NewsResponse>()
    val marketNews: LiveData<NewsResponse> = _marketNews

    private val _CNNTerbaruNews = MutableLiveData<NewsResponse>()
    val CNNTerbaruNews: LiveData<NewsResponse> = _CNNTerbaruNews

    private val _CNNNasionalNews = MutableLiveData<NewsResponse>()
    val CNNNasionalNews: LiveData<NewsResponse> = _CNNNasionalNews

    private val _CNNInternasionalNews = MutableLiveData<NewsResponse>()
    val CNNInternasionalNews: LiveData<NewsResponse> = _CNNInternasionalNews

    private val _MERDEKAJakartaNews = MutableLiveData<NewsResponse>()
    val MERDEKAJakartaNews: LiveData<NewsResponse> = _MERDEKAJakartaNews

    private val _MERDEKADuniaNews = MutableLiveData<NewsResponse>()
    val MERDEKADunisNews: LiveData<NewsResponse> = _MERDEKADuniaNews

    private val _MERDEKAOlahraga = MutableLiveData<NewsResponse>()
    val MERDEKAOlahraga: LiveData<NewsResponse> = _MERDEKAOlahraga

    private val _searchNews = MutableLiveData<NewsResponse>()
    val searchNews: LiveData<NewsResponse> = _searchNews

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getTerbaruNews(){
        _isLoading.value = true
        ApiClient.provideApiService().getTerbaruNews()
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _terbaruNews.postValue(response.body())
                            Log.d("Respository",
                                responseBody.data.toString())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }

    fun getPolitikNews(){
        _isLoading.value = true
        ApiClient.provideApiService().getPolitikNews()
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _politikNews.postValue(response.body())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }

    fun getMarketNews(){
        _isLoading.value = true
        ApiClient.provideApiService().getMarketNews()
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _marketNews.postValue(response.body())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }



    fun getSearchNews(q:String){
        _isLoading.value = true
        ApiClient.provideApiService().getSearchNews(q)
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _searchNews.postValue(response.body())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }

    fun getCNNTerbaruNews(){
        _isLoading.value = true
        ApiClient.provideApiService().getCNNTerbaruNews()
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _CNNTerbaruNews.postValue(response.body())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }

    fun getCNNNasionalNews(){
        _isLoading.value = true
        ApiClient.provideApiService().getCNNNasionalNews()
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _CNNNasionalNews.postValue(response.body())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }

    fun getCNNInternasionalNews(){
        _isLoading.value = true
        ApiClient.provideApiService().getCNNInternasionalNews()
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _CNNInternasionalNews.postValue(response.body())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }

    fun getMERDEKADuniaNews(){
        _isLoading.value = true
        ApiClient.provideApiService().getMERDEKADunia()
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _MERDEKADuniaNews.postValue(response.body())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }

    fun getMERDEKAJakartaNews(){
        _isLoading.value = true
        ApiClient.provideApiService().getMERDEKAJakarta()
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _MERDEKAJakartaNews.postValue(response.body())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }

    fun getMERDEKAOlahragaNews(){
        _isLoading.value = true
        ApiClient.provideApiService().getMERDEKAOlahraga()
            .enqueue(object : Callback<NewsResponse> {

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null){
                            _MERDEKAOlahraga.postValue(response.body())
                        }
                    } else {
                        Log.e(
                            "Repository",
                            "onResponse: Call error with HTTP status code" + response.code()
                        )
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e(
                        "Repository",
                        "onFailure: " + t.localizedMessage
                    )
                }
            })
    }
}