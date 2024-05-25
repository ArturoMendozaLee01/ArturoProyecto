package com.ebc.arturoproyecto.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.ebc.arturoproyecto.viewModels.CalculadoraViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: CalculadoraViewModel){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Propinas", color= Color.White)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary  //Cambiar a Negro
                )
            )
        }
    ) {
        ContentHomeView(paddingValues = it, viewModel= viewModel)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel: CalculadoraViewModel){
    Column(
       modifier =
            Modifier.padding(paddingValues)
                .padding(10.dp)
                .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val state = viewModel.state



    }
}