package com.ebc.arturoproyecto.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ebc.arturoproyecto.R
import com.ebc.arturoproyecto.components.DosCartas

import com.ebc.arturoproyecto.viewModels.CalculadoraViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: CalculadoraViewModel){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Mr. Tips", color= Color.White)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black)
            )
        },
        containerColor = Color.Transparent  // Para el container
    ) {
        ContentHomeView(paddingValues = it, viewModel= viewModel)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel: CalculadoraViewModel){
    Column(
       modifier =
       Modifier
           .padding(paddingValues)
           .padding(10.dp)
           .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val state = viewModel.state

        DosCartas(
            titulo1 = "Total", dato1 = state.cuentaPropina,
            titulo2 = "Propina", dato2 = state.totalPropina
        )
        Spacer(modifier = Modifier.height(10.dp)) // Espacio horizontal
        OutlinedTextField(
            value = state.cuenta,
            onValueChange = {
                viewModel.onValue(it, "Cuenta")  // Cuando se modifica, toma el valor de la función Onvalue "CalculadoraViewModdel"
            },
            label= {Text (text = "Cuenta")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp)) // Espacio horizontal
        OutlinedTextField(
            value = state.propina,
            onValueChange = {
                viewModel.onValue(it, "Propina")  // Cuando se modifica, toma el valor de la función Onvalue "CalculadoraViewModdel"
            },
            label= {Text (text = "Propina %")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedButton(                 // Creamos un botón --> Aquí generamos el porcentaje de propina y los títulos
            onClick = {
                     viewModel.calcular()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "Calcular")
        }

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            onClick = {
                viewModel.limpiar()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        ) {
            Text(text = "Limpiar")
        }

        if(state.mostrarAlerta){
            AlertDialog(
                onDismissRequest = { /*TODO*/ },
                confirmButton = {
                    Button(onClick = {viewModel.cancelarAlerta()}) {
                        Text(text="Aceptar")
                    }
                },
                title= {Text(text="OOoooppss!!!")},
                text = { Text(text = "Lo sentimos, es necesario que nos compartas información adicional")}

            )
        }

        Spacer(modifier = Modifier.height(50.dp))
        val imagenPropinas = painterResource(id = R.drawable.mrpropinas)
        Image(
            painter = imagenPropinas,
            contentDescription = "Imagen Mr Tips"
        )

    }




}