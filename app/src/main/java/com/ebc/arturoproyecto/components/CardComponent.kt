package com.ebc.arturoproyecto.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DosCartas(titulo1: String, dato1: Double, titulo2: String, dato2: Double ){
    Row(
        modifier= Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        CartaPrincipal(titulo = titulo1, dato = dato1,
            modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(10.dp))     // Genera espacio entre las dos cartas
        CartaPrincipal(titulo = titulo2, dato = dato2,
            modifier = Modifier.weight(1f))
    }
}


@Composable
fun CartaPrincipal(titulo:String, dato:Double, modifier: Modifier){
    Card(
        modifier = modifier
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray     //Black
        )
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ){
            Text(text=titulo, color = Color.Black, fontSize = 20.sp)   //White
            Text(text = "$$dato", color = Color.Black, fontSize = 20.sp)   //White
        }
    }
}