package com.example.pruebatecnicaalejandrolopez.provider.services

import com.example.pruebatecnicaalejandrolopez.model.Data
import com.example.pruebatecnicaalejandrolopez.utils.kApiKey
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path

interface WheatherApiClient {
    @GET("?location={city}&units={units}&apikey=8MOzdzNdR7HzRRdQ9kCAi92gm2ggPMol")
    suspend fun getWheater(@Path("city") city: String, @Path("units") units: String): Response<Data>
}