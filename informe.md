# Informe: Patrón de arquitectura y uso de ViewModel/LiveData

Autor: Giorgio Interdonato Palacios  
Estudiante Bootcamp Desarrollo de Aplicaciones en Android  
GitHub: @DonGeeo87

## ¿Qué patrón usé y por qué?
Usé el patrón MVVM (Model–View–ViewModel). Este patrón separa la lógica de negocio (Model y ViewModel) de la interfaz (View). Así el código es más ordenado, fácil de mantener y escalar. También funciona muy bien con los componentes de arquitectura de Jetpack como `ViewModel` y `LiveData`, permitiendo que la vista observe cambios de datos sin manejar lógica compleja.

## ¿Cómo apliqué ViewModel y LiveData?
- Creé `GastoViewModel` que guarda la lista de gastos.
- En el ViewModel, usé `MutableLiveData<List<Gasto>>` internamente y expuse `LiveData<List<Gasto>>` para la vista.
- Cuando se agrega un gasto, el ViewModel actualiza el `LiveData`. La pantalla (`GastoScreen`) observa este `LiveData` y se redibuja sola.

Archivos clave que desarrollé:
- `model/Gasto.kt`: modelo de datos del gasto (nombre, categoría, monto).
- `data/GastoRepository.kt`: repositorio en memoria (fácil de cambiar a Room luego).
- `viewmodel/GastoViewModel.kt`: fuente de verdad de la lista de gastos, expone LiveData.
- `ui/GastoScreen.kt`: pantalla Compose que observa el LiveData con `observeAsState()`.
- `MainActivity.kt`: configura el tema y muestra `GastoScreen`.

## ¿Qué ventajas encontré al usar MVVM?
- Separación de responsabilidades: la UI no contiene reglas de negocio.
- Código más fácil de testear: la lógica está en el ViewModel.
- Reactividad: con `LiveData`, la vista se actualiza automáticamente al cambiar los datos (Patrón Observador).
- Escalabilidad: es simple reemplazar el repositorio en memoria por una base de datos (ej. Room) sin cambiar la UI.


