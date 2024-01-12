package com.example.pruebatecnicaalejandrolopez.usecases.MainActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicaalejandrolopez.domain.GetWeatherUseCase
import com.example.pruebatecnicaalejandrolopez.model.Data
import com.example.pruebatecnicaalejandrolopez.model.ResponseData
import com.example.pruebatecnicaalejandrolopez.model.Weather
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val weatherData = MutableLiveData<ResponseData>()

    var getWeatherUseCase = GetWeatherUseCase()
    fun onCreate(city:String,units:String) {
        viewModelScope.launch {
            val result = getWeatherUseCase(city, units)

            if (result != null) {
                weatherData.postValue(result)
            }
        }
    }
}