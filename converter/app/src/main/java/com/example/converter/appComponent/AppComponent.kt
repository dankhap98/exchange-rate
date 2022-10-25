package com.example.converter.appComponent

import android.content.res.Resources
import com.example.converter.R
import com.example.converter.network.ExchageAPI
import com.example.converter.network.exchengeApiData.GetApiData
import com.example.converter.ui.main.MainViewModel
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(viewModel: MainViewModel)
    fun inject(getApiData: GetApiData)

    val exchageAPI : ExchageAPI
}

@Module
object AppModule{

    @Provides
    fun providexchangeApi(): ExchageAPI {
        val BASE_URL = "https://api.apilayer.com/exchangerates_data/"
//        val bb = Resources.getSystem().getString(R.string.base_api)
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(ExchageAPI::class.java)
    }
}