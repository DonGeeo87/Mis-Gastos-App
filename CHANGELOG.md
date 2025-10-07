# Changelog

Todos los cambios notables de este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es-ES/1.0.0/),
y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.3.0] - 07-10-2025

### Agregado
- **Funcionalidad de eliminar gastos individuales** - Botón rojo de basura en cada gasto
- **UI más compacta** - Reducción del 75% en tamaños para mejor aprovechamiento del espacio
- **Modelo de datos mejorado** con IDs únicos para identificación precisa
- **Optimización de layout** para evitar problemas de constraints

### Corregido
- **Crash al eliminar gastos** - Problema de ID faltante en modelo de dominio resuelto
- **Layout constraints infinitos** - Optimización de LazyColumn y Column anidados
- **Mejoras en UX** - Interfaz más eficiente y responsive

### Técnico
- Agregado campo `id: Long` al modelo `Gasto`
- Actualizada conversión entre `Gasto` y `GastoEntity`
- Implementadas funciones helper para UI compacta
- Mejorado manejo de errores en operaciones de eliminación

## [1.2.0] - 07-10-2025

### Agregado
- **Persistencia de datos con Room Database** - Los gastos ahora se guardan permanentemente
- **Base de datos SQLite local** con entidades y DAOs optimizados
- **Operaciones asíncronas** con corrutinas para mejor rendimiento
- **Funcionalidades adicionales**:
  - Búsqueda de gastos por nombre
  - Filtrado por categorías
  - Eliminación individual y masiva de gastos
  - Cálculo automático de totales
- **Arquitectura mejorada** con separación clara entre capas
- **ViewModel Factory** para inyección de dependencias
- **Manejo robusto de errores** en operaciones de base de datos

### Técnico
- Integración completa de Room Database 2.6.1
- Entity `GastoEntity` con timestamps automáticos
- DAO con operaciones CRUD completas
- Repository pattern con transformación de datos
- Corrutinas para operaciones de I/O
- Migración automática de esquemas

## [1.1.0] - 07-10-2025

### Agregado
- **Header/TopBar moderno** con gradiente de colores de marca (#009fe3 y #312783)
- **Sistema de categorías predefinidas** con emojis para gastos comunes:
  - 🏠 Hogar, 🐕 Mascotas, 📱 Teléfono, 🌐 Internet
  - 💡 Luz, 💧 Agua, 🔥 Gas, 🛒 Supermercado
  - 🚗 Transporte, ⚕️ Salud, 🎬 Entretenimiento, 👕 Ropa
  - 📚 Educación, ⚽ Deportes, 📦 Otros
- **Selector visual de categorías** con scroll horizontal y selección táctil
- **Campo personalizado** para categorías no predefinidas
- **Iconos Material Design extendidos** en todos los campos de entrada
- **Formato de moneda chilena** con separadores de miles
- **Total de gastos** visible en el header
- **Fecha actual** mostrada en el header
- **Diseño de tarjetas moderno** para elementos de gastos
- **Estados vacíos** con mensaje amigable cuando no hay gastos
- **Librería de iconos extendida** (material-icons-extended)

### Mejorado
- **UI/UX completamente rediseñada** con Material Design 3
- **Tema personalizado** con colores de marca
- **Formulario más intuitivo** con iconos descriptivos
- **Lista de gastos mejorada** con emojis de categorías
- **Navegación y scroll** optimizados para mejor experiencia
- **Validación de formularios** mejorada
- **Responsive design** para diferentes tamaños de pantalla

### Técnico
- Integración de `androidx.compose.material:material-icons-extended`
- Componentes reutilizables (`Header`, `CategoriaSelector`, `GastoItem`)
- Arquitectura de componentes modulares
- Gestión de estado mejorada con categorías predefinidas
- Formateo de números con locales chilenos

## [1.0.0] - 07-10-2025

### Agregado
- Implementación inicial de la aplicación MisGastos
- Patrón de arquitectura MVVM (Model-View-ViewModel)
- Modelo de datos `Gasto` con propiedades: nombre, categoría y monto
- Repositorio en memoria `GastoRepository` para almacenamiento temporal
- `GastoViewModel` con LiveData para observación reactiva de la lista de gastos
- Pantalla principal `GastoScreen` desarrollada con Jetpack Compose
- Formulario para agregar nuevos gastos con validación básica
- Lista reactiva que se actualiza automáticamente al agregar gastos
- Colores del logo implementados (#009fe3 y #312783)
- Dependencias de Jetpack Architecture Components:
  - lifecycle-viewmodel-ktx
  - lifecycle-livedata-ktx
  - lifecycle-viewmodel-compose
  - compose-runtime-livedata
- Documentación técnica en `informe.md` explicando:
  - Patrón MVVM utilizado
  - Implementación de ViewModel y LiveData
  - Ventajas del patrón arquitectónico

### Técnico
- Configuración de proyecto Android con Kotlin
- Uso de Jetpack Compose para la interfaz de usuario
- Implementación del Patrón Observador mediante LiveData
- Separación clara de responsabilidades según MVVM
- Código comentado en español para nivel trainee

### Desarrollado por
- **Autor**: Giorgio Interdonato Palacios
- **Bootcamp**: Desarrollo de Aplicaciones en Android
- **GitHub**: @DonGeeo87

---

## [Unreleased]

### Planificado
- Persistencia de datos con Room Database
- Categorías predefinidas de gastos
- Formateo de moneda chilena (CLP)
- Validaciones más robustas
- Filtros y búsqueda de gastos
- Gráficos y estadísticas de gastos
