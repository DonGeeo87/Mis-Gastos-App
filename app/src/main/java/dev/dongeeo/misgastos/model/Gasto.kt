package dev.dongeeo.misgastos.model

// Modelo de datos simple para representar un gasto
// name: nombre del gasto, category: categoría del gasto, amount: monto en CLP
data class Gasto(
    val name: String,
    val category: String,
    val amount: Int
)


