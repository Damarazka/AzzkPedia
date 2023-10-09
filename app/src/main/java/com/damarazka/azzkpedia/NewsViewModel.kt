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

    private val _aboutDaily = MutableLiveData<NewsResponse>()
    val dailyNews get() = _aboutDaily as LiveData<NewsResponse>

    private val _aboutSport = MutableLiveData<NewsResponse>()
    val sportNews get() = _aboutSport as LiveData<NewsResponse>

    private val _aboutWarning = MutableLiveData<NewsResponse>()
    val warningNews get() = _aboutWarning as LiveData<NewsResponse>

    private val _searchNews = MutableLiveData<NewsResponse>()
    val searchNews get() = _searchNews as LiveData<NewsResponse>

    fun getCommonNews() {
        ApiClient.getApiService().getCommonNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    _commonNews.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error Http Status Code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage)
            }

        })
    }

    fun getDailyNews() {
        ApiClient.getApiService().getDailyNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    _aboutDaily.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error Http Status Code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage)
            }

        })
    }

    fun getSportNews() {
        ApiClient.getApiService().getSportNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    _aboutSport.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error Http Status Code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage)
            }

        })
    }

    fun getWarningNews() {
        ApiClient.getApiService().getWarningNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    _aboutWarning.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error Http Status Code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage)
            }

        })
    }

    fun searchNews(query: String) {
        ApiClient.getApiService().getSearchNews(query)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _searchNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }
}