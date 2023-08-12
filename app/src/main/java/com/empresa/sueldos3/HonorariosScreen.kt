package com.empresa.sueldos3


import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HonorariosScreen(onBack: () -> Unit) {
    var sueldoBruto by remember { mutableStateOf("") }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope() // Obtiene el CoroutineScope

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            label = { Text("Ingrese sueldo bruto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val empleadoHonorarios = EmpleadoHonorarios(sueldoBruto.toDoubleOrNull() ?: 0.0)
            val liquido = empleadoHonorarios.calcularLiquido()

            // Usamos coroutineScope para mostrar el Toast
            coroutineScope.launch {
                Toast.makeText(context, "Pago líquido: $liquido", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Calcular sueldo líquido")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBack) {
            Text("Volver al menú principal")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HonorariosScreenPreview() {
    HonorariosScreen {}
}
