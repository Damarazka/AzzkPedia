package com.damarazka.azzkpedia.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiClient {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}