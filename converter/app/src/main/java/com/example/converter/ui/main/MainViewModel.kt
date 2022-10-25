package com.example.converter.ui.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.converter.appComponent.AppComponent
import com.example.converter.network.exchengeApiData.GetApiData
import com.example.converter.network.exchengeApiData.data.ExchangeApiData
import kotlinx.coroutines.DelicateCoroutinesApi

class MainViewModel() : ViewModel() {

    private var exchangeApiData : ExchangeApiData? = null
    private var getData : GetApiData? = null

    private var appComponent: AppComponent? = null

    fun init(component: AppComponent){
        when (appComponent) {
            null -> appComponent = component
            else -> Log.i("VM_init", "appComponent already initialized")
        }
        when (getData) {
            null -> getData = GetApiData(appComponent!!)
            else -> Log.i("VM_init", "getData class already initialized")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun setLatestData(base: String) {
        if (getData != null)
            getData?.setLatestApiData(base = base)
        else
            throw java.lang.Exception("ViewModel is not initialized!")
    }

    fun getLatestData() {
        if (getData?.exchangeApiData != null) {
            exchangeApiData = getData?.exchangeApiData!!
            Log.e("AAAAAAAAA", exchangeApiData.toString())
        }
        else
            Log.e("AAAAAAAAAAAA", "NULL")
    }
}