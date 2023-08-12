package com.empresa.sueldos3

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    private val PORCENTAJE_RETENCION = 0.13

    override fun calcularLiquido(): Double {
        return sueldoBruto * (1 - PORCENTAJE_RETENCION)
    }
}