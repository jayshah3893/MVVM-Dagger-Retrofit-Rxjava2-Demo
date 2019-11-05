package com.nb.daggermvvmdemo

import android.app.Application
import android.os.StrictMode
import com.nb.daggermvvmdemo.network.ApiInterface

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    companion object {
        lateinit var app: App
        val apiInterface: ApiInterface? = null
        fun getAppInstance(): App {
            return app
        }
    }
}