package com.empresa.sueldos3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.empresa.sueldos3.ui.theme.Sueldos3Theme

enum class Screen {
    MAIN, HONORARIOS, REGULAR
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sueldos3Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var currentScreen by remember { mutableStateOf(Screen.MAIN) }
    val context = LocalContext.current

    when (currentScreen) {
        Screen.MAIN -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    currentScreen = Screen.HONORARIOS
                }, modifier = Modifier.padding(8.dp)) {
                    Text("Calcular sueldo para empleado a honorarios")
                }

                Button(onClick = {
                    launchRegularScreen(context)  // Llamamos a la función aquí
                }, modifier = Modifier.padding(8.dp)) {
                    Text("Calcular sueldo para empleado regular")
                }
            }
        }
        Screen.HONORARIOS -> HonorariosScreen {
            currentScreen = Screen.MAIN
        }
        Screen.REGULAR -> {

        }

    }
}
fun launchRegularScreen(context: Context) { // Función separada para iniciar RegularScreen
    val intent = Intent(context, RegularScreen::class.java)
    context.startActivity(intent)
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Sueldos3Theme {
        MainScreen()
    }
}

