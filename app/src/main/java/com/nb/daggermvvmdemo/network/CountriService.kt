package com.nb.daggermvvmdemo.network

import android.util.Log
import com.nb.daggermvvmdemo.di.DaggerApiComponent
import com.nb.daggermvvmdemo.models.Country
import io.reactivex.Single
import javax.inject.Inject

class CountriService {

    @Inject
    lateinit var apiInterface: ApiInterface

    @Inject
    lateinit var mystring: String

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<ArrayList<Country>> {
        Log.d("HELLO", ">>>$mystring")
        return apiInterface.getCountries()
    }
}
