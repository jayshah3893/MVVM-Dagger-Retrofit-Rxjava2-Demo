package com.nb.daggermvvmdemo.network

import com.nb.daggermvvmdemo.models.Country
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Single<ArrayList<Country>>
}