package com.nb.daggermvvmdemo.di

import com.nb.daggermvvmdemo.network.CountriService
import dagger.Component


@Component(modules = [ApiModule::class])
interface ApiComponent{
    fun inject(service : CountriService)
}