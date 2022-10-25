package com.example.converter.network.exchengeApiData.data

data class ExchangeApiData(
    val base: String,
    val date: String,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int
)