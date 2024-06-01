package com.ebc.arturoproyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ebc.arturoproyecto.ui.theme.ArturoProyectoTheme
import com.ebc.arturoproyecto.viewModels.CalculadoraViewModel
import com.ebc.arturoproyecto.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: CalculadoraViewModel by viewModels() //al activar el viewModels (un comportamiento
                                                            // que tiene @Compose
        setContent {
            ArturoProyectoTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ){
                    HomeView(viewModel = viewModel )
                }

            }
        }
    }
}
