package com.ones.seputarindonesia.data.network

import com.ones.seputarindonesia.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/cnbc/terbaru")
    fun getTerbaruNews(
        @Query("q") query: String = "terbaru",
        @Query("language") language: String = "en",
        @Query("pageSize") pageSize: Int = 10,
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/cnbc/news")
    fun getPolitikNews(
        @Query("q") query: String = "news",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/cnbc/market")
    fun getMarketNews(
        @Query("q") query: String = "market",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/cnn/terbaru")
    fun getCNNTerbaruNews(
        @Query("q") query: String = "terbaru",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/cnn/nasional")
    fun getCNNNasionalNews(
        @Query("q") query: String = "nasional",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/cnn/internasional")
    fun getCNNInternasionalNews(
        @Query("q") query: String = "internasional",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/merdeka/dunia")
    fun getMERDEKADunia(
        @Query("q") query: String = "world",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/merdeka/jakarta")
    fun getMERDEKAJakarta(
        @Query("q") query: String = "Jakarta",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/merdeka/olahraga")
    fun getMERDEKAOlahraga(
        @Query("q") query: String = "sport",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "relevancy"
    ): Call<NewsResponse>

    @GET("/v2/everything")
    fun getSearchNews(
        @Query("q") query: String = "Search News",
        @Query("category") category: String = "General",
        @Query("pageSize") pageSize: Int = 10
    ): Call<NewsResponse>

}