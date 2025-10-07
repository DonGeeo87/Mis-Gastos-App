package dev.dongeeo.misgastos.data

import dev.dongeeo.misgastos.model.Gasto

// Repositorio en memoria para almacenar la lista de gastos durante la ejecución.
// En un futuro se puede reemplazar por Room u otra fuente de datos.
class GastoRepository {
    private val internalList: MutableList<Gasto> = mutableListOf()

    fun getAll(): List<Gasto> = internalList.toList()

    fun add(gasto: Gasto) {
        internalList.add(gasto)
    }
}


