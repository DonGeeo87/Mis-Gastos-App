# Changelog

Todos los cambios notables de este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es-ES/1.0.0/),
y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0] - 07-27

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
