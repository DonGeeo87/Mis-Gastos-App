package dev.dongeeo.misgastos.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import dev.dongeeo.misgastos.model.Gasto
import dev.dongeeo.misgastos.viewmodel.GastoViewModel

// Pantalla principal: formulario simple para agregar gastos y lista que observa LiveData
@Composable
fun GastoScreen(viewModel: GastoViewModel = viewModel()) {
    val gastos by viewModel.gastos.observeAsState(emptyList())

    var nombre by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var montoText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre del gasto") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = categoria,
                onValueChange = { categoria = it },
                label = { Text("Categoría") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = montoText,
                onValueChange = { montoText = it.filter { ch -> ch.isDigit() } },
                label = { Text("Monto (CLP)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                val monto = montoText.toIntOrNull() ?: 0
                viewModel.agregarGasto(nombre.trim(), categoria.trim(), monto)
                if (monto > 0 && nombre.isNotBlank() && categoria.isNotBlank()) {
                    nombre = ""
                    categoria = ""
                    montoText = ""
                }
            }) {
                Text("Agregar gasto")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Lista de gastos",
            style = MaterialTheme.typography.titleMedium
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(gastos) { gasto ->
                GastoItem(gasto)
            }
        }
    }
}

@Composable
private fun GastoItem(gasto: Gasto) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = gasto.name, style = MaterialTheme.typography.titleSmall)
                Text(text = gasto.category)
            }
            Text(text = "$${gasto.amount}")
        }
    }
}


