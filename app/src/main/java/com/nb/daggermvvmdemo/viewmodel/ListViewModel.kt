package com.nb.daggermvvmdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nb.daggermvvmdemo.models.Country
import com.nb.daggermvvmdemo.network.CountriService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

class ListViewModel : ViewModel(){

    // Viewmodel Class File

    val countries = MutableLiveData<ArrayList<Country>>()
    val loading = MutableLiveData<Boolean>()

    val countriService = CountriService()
    val disposable = CompositeDisposable()

    fun refresh(){
        fetchCountries()
    }

    fun fetchCountries(){
        loading.value = true
        disposable.add(
            countriService
                .getCountries()
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<ArrayList<Country>>(){
                    override fun onSuccess(value: ArrayList<Country>?) {
                        loading.value = false
                        countries.value = value
                    }

                    override fun onError(e: Throwable?) {
                        loading.value = false
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}