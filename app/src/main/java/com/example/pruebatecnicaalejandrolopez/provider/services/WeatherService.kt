package com.example.pruebatecnicaalejandrolopez.provider.services

import android.util.Log
import com.example.pruebatecnicaalejandrolopez.core.RetrofitHelper
import com.example.pruebatecnicaalejandrolopez.model.Data
import com.example.pruebatecnicaalejandrolopez.model.Location
import com.example.pruebatecnicaalejandrolopez.model.ResponseData
import com.example.pruebatecnicaalejandrolopez.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.withContext

class WeatherService{
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getWeather(city: String, units:String): ResponseData{
        return withContext(Dispatchers.IO){
        val response = retrofit.create(WeatherApiClient::class.java).getWheater(city,units)
            Log.d("Response","${response}")
         response.body() ?: ResponseData(Data(values = Weather(30.0,1000)), Location("San Salvador"))
        }
    }

}