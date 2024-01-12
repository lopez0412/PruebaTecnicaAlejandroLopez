package com.example.pruebatecnicaalejandrolopez.usecases.MainActivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.pruebatecnicaalejandrolopez.R


class MainActivity : AppCompatActivity() {
    private lateinit var botonCambiar: Button
    private val mainViewModel: MainViewModel by viewModels()


    var ciudad = "san salvador"
    var unidades = "metric" // "imperial" for Fahrenheit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEdit = findViewById<EditText>(R.id.searchEdit)
        val searchButton = findViewById<ImageButton>(R.id.searchBtn)
        val temperatura = findViewById<TextView>(R.id.temperatura)
        val textoCiudad = findViewById<TextView>(R.id.location)
        botonCambiar = findViewById<Button>(R.id.btnChange)

        //Button action to change temperature units..
        botonCambiar.setOnClickListener {
            // Disable Button to avoid double click
            botonCambiar.isEnabled = false
            // ********************************//
            if (unidades.equals("metric")){
                unidades = "imperial"
            }else{
                unidades = "metric"
            }
            mainViewModel.onCreate(ciudad,unidades)
        }

        //Search Action City
        searchButton.setOnClickListener {
            it.hideKeyboard()
            ciudad = searchEdit.text.toString()

            mainViewModel.onCreate(ciudad,unidades)
        }

        //Metodo para invocar el viewModel donde trae los datos de la APi
        mainViewModel.onCreate(ciudad,unidades)

        mainViewModel.weatherData.observe(this, Observer {

            cambiarTexto()

            val unitChar = if (unidades.equals("metric")){
                "C"
            }else{
                "F"
            }

            //Set values on Textview
            temperatura.text = "${it.data.values.temperature} $unitChar"
            textoCiudad.text = "${it.location.name}"

            //Enable button after get Data
            botonCambiar.isEnabled = true
            //*******************************//
        })
    }

    fun cambiarTexto(){
        if (unidades.equals("metric")){
            botonCambiar.text = "Change Fahrenheit"
        }else{
            botonCambiar.text = "Change Celsius"
        }
    }

    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }


}