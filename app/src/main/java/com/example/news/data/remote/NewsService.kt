package com.example.news.data.remote

import com.example.news.data.model.news.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") appId: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): NewsModel

}

