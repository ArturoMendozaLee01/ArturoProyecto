package com.ebc.arturoproyecto.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ebc.arturoproyecto.model.CalculadoraState


// En esta clase se herederá las propiedades que tendría un ViewModel de Android
class CalculadoraViewModel: ViewModel(){

    // Lo que vamos a ver
    var state by mutableStateOf(CalculadoraState())
        private set  //El modelo es el que va a calcular el estado
    //Qué pasa con los cálculos que vamos a generer
    fun onValue(value: String, text: String){
        when (text){
            "Cuenta" -> state = state.copy(cuenta = value)
            "Propina" -> state = state.copy(propina = value)
        }
    }
    // Función con la que vamos a calcular, le pregunta el estado a cuenta y propina
    fun calcular(){
        val cuenta = state.cuenta
        val propina = state.propina

        state = if (cuenta != "" && propina != "" ){
            state.copy(
                cuentaPropina = calcularPrecioPropina(cuenta.toDouble(),propina.toDouble()),
                totalPropina = calcularPropina(cuenta.toDouble(), propina.toDouble())
            )
        } else {
            state.copy(
                mostrarAlerta = true
            )
        }
    }

    fun limpiar(){
        state = state.copy(
            cuenta = "",
            propina= "",
            cuentaPropina = 0.0,
            totalPropina = 0.0
        )
    }

    fun cancelarAlerta(){
        state = state.copy(
            mostrarAlerta = false
        )
    }





    // Aquí generamos dos funciones:
    // 1) Cuenta + Propina

    private fun calcularPrecioPropina(cuenta: Double, propina:Double): Double {
        val propinaFinal = calcularPropina(cuenta, propina)
        return  cuenta + propinaFinal
    }
    // 2) El porcentaje de la propina
    private fun calcularPropina(cuenta: Double, propina:Double): Double{
        val propina = cuenta * (propina/100)

        return propina
    }

}