package dev.dongeeo.misgastos.model

// Modelo de datos simple para representar un gasto
// id: identificador único, name: nombre del gasto, category: categoría del gasto, amount: monto en CLP
data class Gasto(
    val id: Long = 0,
    val name: String,
    val category: String,
    val amount: Int
)


