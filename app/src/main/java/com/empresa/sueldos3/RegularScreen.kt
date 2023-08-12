package com.empresa.sueldos3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegularScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regular_screen)

        val sueldoBrutoEditText = findViewById<EditText>(R.id.sueldoBrutoEditText)
        val calcularButton = findViewById<Button>(R.id.calcularButton)
        val volverButton = findViewById<Button>(R.id.volverButton)

        calcularButton.setOnClickListener {
            val sueldoBruto = sueldoBrutoEditText.text.toString().toDoubleOrNull() ?: 0.0
            val empleado = EmpleadoRegular(sueldoBruto)
            val sueldoLiquido = empleado.calcularLiquido()
            Toast.makeText(this, "Sueldo líquido: $sueldoLiquido", Toast.LENGTH_LONG).show()
        }

        volverButton.setOnClickListener {
            finish()
        }
    }
}