package dev.dongeeo.misgastos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.dongeeo.misgastos.model.Categoria
import dev.dongeeo.misgastos.model.CategoriasPredefinidas
import dev.dongeeo.misgastos.ui.theme.BrandBlue

@Composable
fun CategoriaSelector(
    categoriaSeleccionada: String?,
    onCategoriaSeleccionada: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Categoría",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurface
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Selector de categorías con scroll horizontal
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(CategoriasPredefinidas.lista) { categoria ->
                CategoriaItem(
                    categoria = categoria,
                    isSelected = categoriaSeleccionada == categoria.id,
                    onClick = { onCategoriaSeleccionada(categoria.id) }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Campo de texto para categoría personalizada
        OutlinedTextField(
            value = categoriaSeleccionada?.let { 
                CategoriasPredefinidas.obtenerPorId(it)?.nombre ?: it 
            } ?: "",
            onValueChange = { onCategoriaSeleccionada(it) },
            label = { Text("O escribe una categoría personalizada") },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Ej: Medicina, Seguros...") },
            enabled = categoriaSeleccionada == null || CategoriasPredefinidas.obtenerPorId(categoriaSeleccionada) == null,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Category,
                    contentDescription = "Categoría personalizada",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )
    }
}

@Composable
private fun CategoriaItem(
    categoria: Categoria,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clickable { onClick() }
            .then(
                if (isSelected) {
                    Modifier.border(
                        width = 2.dp,
                        color = BrandBlue,
                        shape = RoundedCornerShape(12.dp)
                    )
                } else {
                    Modifier
                }
            ),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                categoria.color.copy(alpha = 0.1f)
            } else {
                MaterialTheme.colorScheme.surfaceVariant
            }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isSelected) 4.dp else 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = categoria.emoji,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = categoria.nombre,
                fontSize = 12.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) BrandBlue else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
