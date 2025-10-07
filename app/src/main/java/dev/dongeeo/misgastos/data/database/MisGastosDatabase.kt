package dev.dongeeo.misgastos.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import dev.dongeeo.misgastos.data.dao.GastoDao
import dev.dongeeo.misgastos.data.entity.GastoEntity

/**
 * Base de datos principal de la aplicación MisGastos
 * Utiliza Room para manejar la persistencia de datos SQLite
 */
@Database(
    entities = [GastoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MisGastosDatabase : RoomDatabase() {
    
    /**
     * Proporciona acceso al DAO de gastos
     */
    abstract fun gastoDao(): GastoDao
    
    companion object {
        // Nombre de la base de datos
        private const val DATABASE_NAME = "mis_gastos_database"
        
        // Instancia singleton de la base de datos
        @Volatile
        private var INSTANCE: MisGastosDatabase? = null
        
        /**
         * Obtiene la instancia de la base de datos (Singleton pattern)
         * @param context Contexto de la aplicación
         * @return Instancia de MisGastosDatabase
         */
        fun getDatabase(context: Context): MisGastosDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MisGastosDatabase::class.java,
                    DATABASE_NAME
                )
                .fallbackToDestructiveMigration() // Permite recrear la DB si hay cambios de schema
                .build()
                INSTANCE = instance
                instance
            }
        }
        
        /**
         * Cierra la base de datos (útil para testing)
         */
        fun closeDatabase() {
            INSTANCE?.close()
            INSTANCE = null
        }
    }
}
