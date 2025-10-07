package dev.dongeeo.misgastos.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import dev.dongeeo.misgastos.data.entity.GastoEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) para operaciones de base de datos
 * Define las consultas SQL que se pueden realizar en la tabla gastos
 */
@Dao
interface GastoDao {
    
    /**
     * Obtiene todos los gastos como LiveData para observación reactiva
     * Se actualiza automáticamente cuando cambian los datos
     */
    @Query("SELECT * FROM gastos ORDER BY fechaCreacion DESC")
    fun getAllGastosLiveData(): LiveData<List<GastoEntity>>
    
    /**
     * Obtiene todos los gastos como Flow (alternativa moderna a LiveData)
     */
    @Query("SELECT * FROM gastos ORDER BY fechaCreacion DESC")
    fun getAllGastosFlow(): Flow<List<GastoEntity>>
    
    /**
     * Obtiene todos los gastos como lista simple (para operaciones síncronas)
     */
    @Query("SELECT * FROM gastos ORDER BY fechaCreacion DESC")
    suspend fun getAllGastos(): List<GastoEntity>
    
    /**
     * Inserta un nuevo gasto
     * @OnConflictStrategy.IGNORE ignora si ya existe un gasto con el mismo ID
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGasto(gasto: GastoEntity): Long
    
    /**
     * Actualiza un gasto existente
     */
    @Update
    suspend fun updateGasto(gasto: GastoEntity)
    
    /**
     * Elimina un gasto específico por ID
     */
    @Delete
    suspend fun deleteGasto(gasto: GastoEntity)
    
    /**
     * Elimina un gasto por ID
     */
    @Query("DELETE FROM gastos WHERE id = :gastoId")
    suspend fun deleteGastoById(gastoId: Long)
    
    /**
     * Elimina todos los gastos
     */
    @Query("DELETE FROM gastos")
    suspend fun deleteAllGastos()
    
    /**
     * Busca gastos por nombre
     */
    @Query("SELECT * FROM gastos WHERE nombre LIKE '%' || :searchQuery || '%' ORDER BY fechaCreacion DESC")
    suspend fun searchGastos(searchQuery: String): List<GastoEntity>
    
    /**
     * Obtiene gastos por categoría
     */
    @Query("SELECT * FROM gastos WHERE categoria = :categoria ORDER BY fechaCreacion DESC")
    suspend fun getGastosByCategoria(categoria: String): List<GastoEntity>
    
    /**
     * Obtiene el total de gastos
     */
    @Query("SELECT SUM(monto) FROM gastos")
    suspend fun getTotalGastos(): Int?
}
