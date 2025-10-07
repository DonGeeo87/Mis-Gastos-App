package dev.dongeeo.misgastos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import dev.dongeeo.misgastos.data.GastoRepository
import dev.dongeeo.misgastos.data.database.MisGastosDatabase
import dev.dongeeo.misgastos.model.Gasto
import kotlinx.coroutines.launch

// ViewModel que mantiene el estado de la lista de gastos y expone LiveData
class GastoViewModel(application: Application) : AndroidViewModel(application) {

    // Inicialización del repositorio con Room Database
    private val database = MisGastosDatabase.getDatabase(application)
    private val repository = GastoRepository(database.gastoDao())

    // LiveData para observar la lista de gastos desde la UI (Patrón Observador)
    val gastos: LiveData<List<Gasto>> = repository.getAllGastosLiveData()

    // Agrega un gasto usando corrutinas para operaciones de base de datos
    fun agregarGasto(nombre: String, categoria: String, monto: Int) {
        if (nombre.isBlank() || categoria.isBlank() || monto <= 0) return
        
        viewModelScope.launch {
            try {
                val gasto = Gasto(name = nombre.trim(), category = categoria.trim(), amount = monto)
                repository.addGasto(gasto)
            } catch (e: Exception) {
                // Manejo de errores - en producción podrías mostrar un Toast o Snackbar
                e.printStackTrace()
            }
        }
    }
    
    // Elimina un gasto
    fun eliminarGasto(gasto: Gasto) {
        viewModelScope.launch {
            try {
                repository.deleteGasto(gasto)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    
    // Elimina todos los gastos
    fun eliminarTodosLosGastos() {
        viewModelScope.launch {
            try {
                repository.deleteAllGastos()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    
    // Busca gastos por nombre
    fun buscarGastos(query: String, onResult: (List<Gasto>) -> Unit) {
        viewModelScope.launch {
            try {
                val resultados = repository.searchGastos(query)
                onResult(resultados)
            } catch (e: Exception) {
                e.printStackTrace()
                onResult(emptyList())
            }
        }
    }
    
    // Obtiene el total de gastos
    fun obtenerTotalGastos(onResult: (Int) -> Unit) {
        viewModelScope.launch {
            try {
                val total = repository.getTotalGastos()
                onResult(total)
            } catch (e: Exception) {
                e.printStackTrace()
                onResult(0)
            }
        }
    }
}


