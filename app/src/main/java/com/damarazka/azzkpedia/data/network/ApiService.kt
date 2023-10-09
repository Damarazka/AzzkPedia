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

    @GET("everything")
    fun getDailyNews(
        @Query("q") keyWord: String = "Daily",
        @Query("language") language: String = "en"
    ) : Call<NewsResponse>

    @GET("top-headLines")
    fun getSportNews(
        @Query("category") sources:String = "sports",
        @Query("language") language: String = "en"
    ) : Call<NewsResponse>

    @GET("everything")
    fun getWarningNews(
        @Query("q") keyWord: String = "warning",
        @Query("language") language: String = "en"
    ) : Call<NewsResponse>

    @GET("everything")
    fun getSearchNews(
        @Query("q") keyWord: String,
        @Query("pageSize") pageSize: Int = 19
    ) : Call<NewsResponse>
}