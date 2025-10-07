package dev.dongeeo.misgastos.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory para crear instancias de GastoViewModel con dependencias
 */
class GastoViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GastoViewModel::class.java)) {
            return GastoViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
