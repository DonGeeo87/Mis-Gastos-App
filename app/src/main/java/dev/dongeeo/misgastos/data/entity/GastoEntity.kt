package dev.dongeeo.misgastos.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Entidad de Room Database para persistir gastos
 * Representa una tabla en la base de datos SQLite
 */
@Entity(tableName = "gastos")
data class GastoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nombre: String,
    val categoria: String,
    val monto: Int,
    val fechaCreacion: Long = System.currentTimeMillis()
) {
    /**
     * Convierte la entidad a modelo de dominio
     */
    fun toDomainModel(): dev.dongeeo.misgastos.model.Gasto {
        return dev.dongeeo.misgastos.model.Gasto(
            id = id,
            name = nombre,
            category = categoria,
            amount = monto
        )
    }
    
    companion object {
        /**
         * Convierte modelo de dominio a entidad
         */
        fun fromDomainModel(gasto: dev.dongeeo.misgastos.model.Gasto): GastoEntity {
            return GastoEntity(
                id = gasto.id,
                nombre = gasto.name,
                categoria = gasto.category,
                monto = gasto.amount
            )
        }
    }
}
