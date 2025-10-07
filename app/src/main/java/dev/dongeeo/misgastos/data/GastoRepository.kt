package dev.dongeeo.misgastos.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import dev.dongeeo.misgastos.data.dao.GastoDao
import dev.dongeeo.misgastos.data.entity.GastoEntity
import dev.dongeeo.misgastos.model.Gasto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repositorio que maneja el acceso a datos de gastos
 * Utiliza Room Database para persistencia de datos
 */
class GastoRepository(private val gastoDao: GastoDao) {
    
    /**
     * Obtiene todos los gastos como LiveData para observación reactiva
     */
    fun getAllGastosLiveData(): LiveData<List<Gasto>> {
        val result = MutableLiveData<List<Gasto>>()
        val observer = Observer<List<GastoEntity>> { entities ->
            result.value = entities.map { it.toDomainModel() }
        }
        gastoDao.getAllGastosLiveData().observeForever(observer)
        return result
    }
    
    /**
     * Obtiene todos los gastos (operación síncrona)
     */
    suspend fun getAllGastos(): List<Gasto> = withContext(Dispatchers.IO) {
        gastoDao.getAllGastos().map { it.toDomainModel() }
    }
    
    /**
     * Agrega un nuevo gasto a la base de datos
     */
    suspend fun addGasto(gasto: Gasto): Long = withContext(Dispatchers.IO) {
        val entity = GastoEntity.fromDomainModel(gasto)
        gastoDao.insertGasto(entity)
    }
    
    /**
     * Actualiza un gasto existente
     */
    suspend fun updateGasto(gasto: Gasto) = withContext(Dispatchers.IO) {
        val entity = GastoEntity.fromDomainModel(gasto)
        gastoDao.updateGasto(entity)
    }
    
    /**
     * Elimina un gasto
     */
    suspend fun deleteGasto(gasto: Gasto) = withContext(Dispatchers.IO) {
        val entity = GastoEntity.fromDomainModel(gasto)
        gastoDao.deleteGasto(entity)
    }
    
    /**
     * Elimina todos los gastos
     */
    suspend fun deleteAllGastos() = withContext(Dispatchers.IO) {
        gastoDao.deleteAllGastos()
    }
    
    /**
     * Busca gastos por nombre
     */
    suspend fun searchGastos(query: String): List<Gasto> = withContext(Dispatchers.IO) {
        gastoDao.searchGastos(query).map { it.toDomainModel() }
    }
    
    /**
     * Obtiene gastos por categoría
     */
    suspend fun getGastosByCategoria(categoria: String): List<Gasto> = withContext(Dispatchers.IO) {
        gastoDao.getGastosByCategoria(categoria).map { it.toDomainModel() }
    }
    
    /**
     * Obtiene el total de gastos
     */
    suspend fun getTotalGastos(): Int = withContext(Dispatchers.IO) {
        gastoDao.getTotalGastos() ?: 0
    }
}



