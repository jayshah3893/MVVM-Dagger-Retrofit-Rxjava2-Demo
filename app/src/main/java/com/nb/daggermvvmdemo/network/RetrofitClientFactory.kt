package com.nb.daggermvvmdemo.network

import com.nb.daggermvvmdemo.App.Companion.apiInterface
import com.nb.daggermvvmdemo.models.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientFactory {
    private val mBaseUrl = "https://raw.githubusercontent.com"

    fun getRestApis(): ApiInterface {
        if (apiInterface != null) {
            return apiInterface
        }
        return getRetroFitClient()
    }

    fun getRetroFitClient(): ApiInterface {
        return Retrofit
            .Builder()
            .baseUrl(mBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    fun getCountries() : Single<ArrayList<Country>>{
        return getRestApis().getCountries()
    }
}
