package com.empresa.sueldos3

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    private val PORCENTAJE_RETENCION = 0.20

    override fun calcularLiquido(): Double {
        return sueldoBruto * (1 - PORCENTAJE_RETENCION)
    }
}