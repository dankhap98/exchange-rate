package com.example.converter.network

import com.example.converter.network.exchengeApiData.data.ExchangeApiData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ExchageAPI {

    @Headers("apikey: GuoDVAURkYXMNKb6IJeTEqkbWO1kMY2u")
    @GET("latest")
    fun getLatest(
        @Query("symbols") symbols : String = "" ,
        @Query("base") base : String = ""
        ): Call<ExchangeApiData>
}