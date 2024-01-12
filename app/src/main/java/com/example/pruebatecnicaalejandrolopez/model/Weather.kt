package com.example.pruebatecnicaalejandrolopez.model

data class Wheather(
    val temperature: Double,
    val wheatherCode: Int
)

data class Location(
    val name:String
)

data class Data(
    val values : Wheather
)
