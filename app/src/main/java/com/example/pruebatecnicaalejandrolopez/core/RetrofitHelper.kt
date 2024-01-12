package com.example.pruebatecnicaalejandrolopez.core

import com.example.pruebatecnicaalejandrolopez.utils.kBaseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(kBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}