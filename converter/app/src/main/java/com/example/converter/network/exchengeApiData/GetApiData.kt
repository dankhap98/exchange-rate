package com.example.converter.network.exchengeApiData

import android.util.Log
import com.example.converter.appComponent.AppComponent
import com.example.converter.network.ExchageAPI
//import com.example.converter.network.RetrofitClient
import com.example.converter.network.exchengeApiData.data.ExchangeApiData
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DateFormatSymbols
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
class GetApiData(appComponent: AppComponent) {

    var exchangeApiData : ExchangeApiData? = null
    private var errorMessage : String? = null
    private var successRecive : Boolean = true

    @Inject
    lateinit var api : ExchageAPI

    init {
        appComponent.inject(this)
        setLatestApiData()
    }

    @DelicateCoroutinesApi
    fun setLatestApiData(symbols: String = "", base : String = "EUR" ){
        GlobalScope.launch(Dispatchers.IO){
            api.getLatest(symbols, base).enqueue(object : Callback<ExchangeApiData> {
                override fun onResponse(
                    call: Call<ExchangeApiData>,
                    response: Response<ExchangeApiData>
                ) {
                    exchangeApiData = response.body()
                    if (exchangeApiData == null)
                        errorMessage = "response.body = null"
                    successRecive = response.isSuccessful
                }

                override fun onFailure(call: Call<ExchangeApiData>, t: Throwable) {
                    Log.e("API_EROR", t.message!!)
                    errorMessage = t.message
                    successRecive = false
                }
            })
        }
    }
}