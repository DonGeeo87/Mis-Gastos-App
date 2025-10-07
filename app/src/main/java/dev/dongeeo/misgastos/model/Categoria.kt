package dev.dongeeo.misgastos.model

// Modelo para categorías predefinidas con emojis
data class Categoria(
    val id: String,
    val nombre: String,
    val emoji: String,
    val color: androidx.compose.ui.graphics.Color
)

// Categorías clásicas que todas las personas tienen en sus gastos
object CategoriasPredefinidas {
    val lista = listOf(
        Categoria("hogar", "Hogar", "🏠", androidx.compose.ui.graphics.Color(0xFF4CAF50)),
        Categoria("mascotas", "Mascotas", "🐕", androidx.compose.ui.graphics.Color(0xFF8BC34A)),
        Categoria("telefono", "Teléfono", "📱", androidx.compose.ui.graphics.Color(0xFF2196F3)),
        Categoria("internet", "Internet", "🌐", androidx.compose.ui.graphics.Color(0xFF00BCD4)),
        Categoria("luz", "Luz", "💡", androidx.compose.ui.graphics.Color(0xFFFFC107)),
        Categoria("agua", "Agua", "💧", androidx.compose.ui.graphics.Color(0xFF00E5FF)),
        Categoria("gas", "Gas", "🔥", androidx.compose.ui.graphics.Color(0xFFFF5722)),
        Categoria("supermercado", "Supermercado", "🛒", androidx.compose.ui.graphics.Color(0xFF4CAF50)),
        Categoria("transporte", "Transporte", "🚗", androidx.compose.ui.graphics.Color(0xFF607D8B)),
        Categoria("salud", "Salud", "⚕️", androidx.compose.ui.graphics.Color(0xFFE91E63)),
        Categoria("entretenimiento", "Entretenimiento", "🎬", androidx.compose.ui.graphics.Color(0xFF9C27B0)),
        Categoria("ropa", "Ropa", "👕", androidx.compose.ui.graphics.Color(0xFFFF9800)),
        Categoria("educacion", "Educación", "📚", androidx.compose.ui.graphics.Color(0xFF3F51B5)),
        Categoria("deportes", "Deportes", "⚽", androidx.compose.ui.graphics.Color(0xFF009688)),
        Categoria("otros", "Otros", "📦", androidx.compose.ui.graphics.Color(0xFF795548))
    )
    
    fun obtenerPorId(id: String): Categoria? {
        return lista.find { it.id == id }
    }
    
    fun obtenerPorNombre(nombre: String): Categoria? {
        return lista.find { it.nombre.equals(nombre, ignoreCase = true) }
    }
}
