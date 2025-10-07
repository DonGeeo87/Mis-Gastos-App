package dev.dongeeo.misgastos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.dongeeo.misgastos.data.GastoRepository
import dev.dongeeo.misgastos.model.Gasto

// ViewModel que mantiene el estado de la lista de gastos y expone LiveData
class GastoViewModel(
    private val repository: GastoRepository = GastoRepository()
) : ViewModel() {

    // LiveData para observar la lista de gastos desde la UI (Patrón Observador)
    private val _gastos: MutableLiveData<List<Gasto>> = MutableLiveData(emptyList())
    val gastos: LiveData<List<Gasto>> = _gastos

    // Agrega un gasto y actualiza el LiveData para notificar a los observadores
    fun agregarGasto(nombre: String, categoria: String, monto: Int) {
        if (nombre.isBlank() || categoria.isBlank() || monto <= 0) return
        repository.add(Gasto(nombre, categoria, monto))
        _gastos.value = repository.getAll()
    }
}


