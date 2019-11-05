package com.nb.daggermvvmdemo.di

import com.nb.daggermvvmdemo.network.ApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule{

    private val mBaseUrl = "https://raw.githubusercontent.com"

    @Provides
    fun providesCountriesApi() : ApiInterface{
        return Retrofit
            .Builder()
            .baseUrl(mBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    fun providesStrings() : String{
        return "HELLo DAGGER"
    }
}