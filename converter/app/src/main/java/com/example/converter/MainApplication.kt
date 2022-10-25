package com.example.converter

import android.app.Application
import android.content.Context
import com.example.converter.appComponent.AppComponent
import com.example.converter.appComponent.AppModule
import com.example.converter.appComponent.DaggerAppComponent

class MainApplication: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule).build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApplication -> appComponent
        else -> applicationContext.appComponent
    }