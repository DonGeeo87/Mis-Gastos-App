package dev.dongeeo.misgastos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.livedata.observeAsState
import dev.dongeeo.misgastos.model.Gasto
import dev.dongeeo.misgastos.model.CategoriasPredefinidas
import dev.dongeeo.misgastos.ui.components.CategoriaSelector
import dev.dongeeo.misgastos.ui.components.HeaderWithTotal
import dev.dongeeo.misgastos.ui.theme.BrandBlue
import dev.dongeeo.misgastos.viewmodel.GastoViewModel
import dev.dongeeo.misgastos.viewmodel.GastoViewModelFactory

// Función helper para reducir tamaños globalmente al 75%
private fun Modifier.compactPadding(): Modifier = this.padding(12.dp) // 16 * 0.75
private fun Modifier.compactPaddingSmall(): Modifier = this.padding(8.dp) // 12 * 0.75
private fun Modifier.compactSpacing(): Modifier = this.height(18.dp) // 24 * 0.75
private fun Modifier.compactSpacingSmall(): Modifier = this.height(9.dp) // 12 * 0.75

// Pantalla principal: formulario moderno para agregar gastos y lista mejorada
@Composable
fun GastoScreen(
    viewModel: GastoViewModel = viewModel(
        factory = GastoViewModelFactory(LocalContext.current.applicationContext as android.app.Application)
    ),
    modifier: Modifier = Modifier
) {
    val gastos by viewModel.gastos.observeAsState(emptyList())

    var nombre by remember { mutableStateOf("") }
    var categoriaSeleccionada by remember { mutableStateOf<String?>(null) }
    var montoText by remember { mutableStateOf("") }

    val totalGastos = gastos.sumOf { it.amount }

    Column(modifier = modifier.fillMaxSize()) {
        // Header con total de gastos
        HeaderWithTotal(totalGastos = totalGastos)
        
        // Contenido principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .compactPadding()
        ) {
            // Formulario de agregar gasto
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    modifier = Modifier.compactPadding()
                ) {
                    Text(
                        text = "Nuevo Gasto",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    
                    Spacer(modifier = Modifier.compactSpacingSmall())
                    
                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Nombre del gasto") },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Ej: Compra en el supermercado") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Receipt,
                                contentDescription = "Nombre del gasto",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    )
                    
                    Spacer(modifier = Modifier.compactSpacingSmall())
                    
                    // Selector de categorías
                    CategoriaSelector(
                        categoriaSeleccionada = categoriaSeleccionada,
                        onCategoriaSeleccionada = { categoriaSeleccionada = it }
                    )
                    
                    Spacer(modifier = Modifier.compactSpacingSmall())
                    
                    OutlinedTextField(
                        value = montoText,
                        onValueChange = { montoText = it.filter { ch -> ch.isDigit() } },
                        label = { Text("Monto (CLP)") },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Ej: 50000") },
                        leadingIcon = { 
                            Icon(
                                imageVector = Icons.Default.AttachMoney,
                                contentDescription = "Peso chileno",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    )
                    
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    Button(
                        onClick = {
                            try {
                                val monto = montoText.toIntOrNull() ?: 0
                                val categoriaNombre = categoriaSeleccionada?.let { id ->
                                    CategoriasPredefinidas.obtenerPorId(id)?.nombre ?: id
                                } ?: ""
                                
                                if (monto > 0 && nombre.isNotBlank() && categoriaNombre.isNotBlank()) {
                                    viewModel.agregarGasto(nombre.trim(), categoriaNombre, monto)
                                    nombre = ""
                                    categoriaSeleccionada = null
                                    montoText = ""
                                }
                            } catch (e: Exception) {
                                // Manejo de errores silencioso para evitar crashes
                                e.printStackTrace()
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = BrandBlue
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = "Agregar Gasto",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.compactSpacing())

            // Lista de gastos
            Text(
                text = "Historial de Gastos",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Spacer(modifier = Modifier.compactSpacingSmall())
            
            if (gastos.isEmpty()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .compactPadding(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No hay gastos registrados aún.\n¡Agrega tu primer gasto!",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp), // Altura reducida para UI más compacta
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(gastos.reversed()) { gasto ->
                        GastoItem(gasto) { gastoToDelete ->
                            viewModel.eliminarGasto(gastoToDelete)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun GastoItem(gasto: Gasto, onDelete: (Gasto) -> Unit) {
    val categoria = CategoriasPredefinidas.obtenerPorNombre(gasto.category)
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .compactPadding(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Emoji de la categoría
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = categoria?.color?.copy(alpha = 0.1f) ?: MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = categoria?.emoji ?: "📦",
                    fontSize = 20.sp
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            // Información del gasto
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = gasto.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = categoria?.nombre ?: gasto.category,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            // Monto
            Text(
                text = "$${gasto.amount.toString().replace(Regex("(\\d)(?=(\\d{3})+$)"), "$1.")}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            
            Spacer(modifier = Modifier.width(8.dp))
            
            // Botón de eliminar
            IconButton(
                onClick = { onDelete(gasto) },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Eliminar gasto",
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}


