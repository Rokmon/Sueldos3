package com.empresa.sueldos3

abstract class Empleado(protected val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}