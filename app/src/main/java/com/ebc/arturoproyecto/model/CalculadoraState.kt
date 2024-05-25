package com.ebc.arturoproyecto.model

data class CalculadoraState(
    val cuenta: String = "",
    val propina: String = "",
    val cuentaPropina: Double = 0.0,
    val totalPropina: Double= 0.0,
    val mostrarAlerta: Boolean = false
)