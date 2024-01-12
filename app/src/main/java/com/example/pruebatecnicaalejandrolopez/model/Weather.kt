package com.example.pruebatecnicaalejandrolopez.model

data class Weather(
    val temperature: Double,
    val weatherCode: Int
)

data class Location(
    val name:String
)

data class ResponseData(
    val data : Data,
    val location : Location
)

data class Data(
    val values: Weather
)
