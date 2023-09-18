package com.damarazka.azzkpedia

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.damarazka.azzkpedia.data.NewsResponse
import com.damarazka.azzkpedia.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    private val _commonNews = MutableLiveData<NewsResponse>()
    val commonNews get() = _commonNews as LiveData<NewsResponse>

    fun getCommonNews() {
        ApiClient.getApiService().getCommonNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    Log.i("ViewModel", "onResponse: ${response.body()} ")
                    _commonNews.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error Http Status Code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage )
            }

        })
    }
}