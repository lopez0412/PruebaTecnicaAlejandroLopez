package com.example.pruebatecnicaalejandrolopez.provider

import com.example.pruebatecnicaalejandrolopez.model.Data
import com.example.pruebatecnicaalejandrolopez.model.ResponseData
import com.example.pruebatecnicaalejandrolopez.provider.services.WeatherService

class WeatherRepository {

    private val api = WeatherService()

    suspend fun getWeather(city:String, units: String): ResponseData{
        val response = api.getWeather(city,units)
        return response
    }
}