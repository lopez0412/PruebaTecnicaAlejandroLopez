package com.example.pruebatecnicaalejandrolopez.domain

import com.example.pruebatecnicaalejandrolopez.model.Data

import com.example.pruebatecnicaalejandrolopez.model.ResponseData
import com.example.pruebatecnicaalejandrolopez.provider.WeatherRepository
import com.example.pruebatecnicaalejandrolopez.provider.services.WeatherService

class GetWeatherUseCase {
    private val repository = WeatherRepository()

    suspend operator fun invoke(city:String,units:String): ResponseData {
        return repository.getWeather(city, units)
    }
}