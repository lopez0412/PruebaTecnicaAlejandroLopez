package com.example.pruebatecnicaalejandrolopez.provider.services

import com.example.pruebatecnicaalejandrolopez.model.Data
import com.example.pruebatecnicaalejandrolopez.model.ResponseData
import retrofit2.Call
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApiClient {
    @GET("realtime?")
    suspend fun getWheater(@Query("location") city: String, @Query("units") units: String, @Query("apikey") apikey:String = "8MOzdzNdR7HzRRdQ9kCAi92gm2ggPMol"): Response<ResponseData>
}