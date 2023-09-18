package com.damarazka.azzkpedia.data.network

import com.damarazka.azzkpedia.data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("everything")
    fun getCommonNews(
        @Query("q") keyWord : String = "common",
        @Query("language") language : String = "en",
        @Query("sortBy") sortBy : String = "popularity",
        @Query("pageSize") pageSize : Int = 30,
    ) : Call<NewsResponse>
}