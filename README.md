# 💰 MisGastos APP

<div align="center">

![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![GitHub Pages](https://img.shields.io/badge/GitHub%20Pages-222222?style=for-the-badge&logo=github&logoColor=white)

**Landing page moderna y responsive para la aplicación MisGastos**

[![Website](https://img.shields.io/badge/Website-Live-brightgreen.svg)](https://dongeo87.github.io/MisGastos/)
[![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)](https://github.com/DonGeeo87/MisGastos)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)

</div>

---

## 🌟 Características

### 🎨 **Diseño Moderno**
- **Diseño responsive** que se adapta a cualquier dispositivo
- **Colores de marca** (#009FE3 y #312783) consistentes
- **Animaciones fluidas** y efectos visuales modernos
- **Gradientes dinámicos** y orbes flotantes de fondo

### ⚡ **Rendimiento Optimizado**
- **CSS moderno** con variables CSS y Flexbox/Grid
- **JavaScript vanilla** sin dependencias pesadas
- **Lazy loading** de imágenes y contenido
- **Animaciones optimizadas** con requestAnimationFrame

### 🔧 **Funcionalidades Avanzadas**
- **Navegación suave** con scroll spy
- **Efectos parallax** en elementos de fondo
- **Animaciones de entrada** con Intersection Observer
- **Efectos hover** interactivos y magnetismo
- **Botón back-to-top** inteligente
- **Menú móvil** responsive con animaciones

### 📱 **Experiencia de Usuario**
- **Mockups interactivos** de la aplicación
- **Secciones bien estructuradas** para mostrar características
- **Call-to-actions** claros y atractivos
- **Información del desarrollador** y tecnologías
- **Enlaces a GitHub** y descarga directa

---

## 🏗️ Estructura del Proyecto

```
MisGastos/
├── index.html          # Página principal
├── styles.css          # Estilos principales
├── script.js           # Funcionalidades JavaScript
├── README.md           # Documentación
├── .gitignore          # Archivos ignorados
└── assets/             # Recursos estáticos
    ├── favicon.ico     # Favicon
    ├── og-image.png    # Imagen Open Graph
    └── screenshots/    # Capturas de pantalla
```

---

## 🚀 Tecnologías Utilizadas

### **Frontend**
- **HTML5** - Estructura semántica moderna
- **CSS3** - Estilos avanzados con variables y animaciones
- **JavaScript ES6+** - Interactividad y efectos modernos

### **Características CSS**
- **CSS Variables** - Sistema de colores y espaciado consistente
- **Flexbox & Grid** - Layouts modernos y responsive
- **Animaciones CSS** - Transiciones suaves y keyframes
- **Media Queries** - Diseño adaptativo para móviles

### **JavaScript Moderno**
- **ES6+ Features** - Arrow functions, destructuring, modules
- **Intersection Observer** - Animaciones basadas en scroll
- **RequestAnimationFrame** - Animaciones optimizadas
- **Event Delegation** - Manejo eficiente de eventos

### **Optimizaciones**
- **Lazy Loading** - Carga diferida de contenido
- **Debounce/Throttle** - Optimización de eventos
- **Performance Monitoring** - Monitoreo de FPS
- **Error Handling** - Manejo robusto de errores

---

## 📦 Instalación y Configuración

### **Clonar el Repositorio**
```bash
git clone https://github.com/DonGeeo87/MisGastos.git
cd MisGastos
```

### **GitHub Pages (Automático)**
1. Sube los archivos a tu repositorio
2. Ve a Settings > Pages
3. Selecciona "Deploy from a branch"
4. Elige la rama `main` y carpeta `/ (root)`
5. Tu sitio estará disponible en `https://tu-usuario.github.io/MisGastos/`

### **Servidor Local**
```bash
# Con Python
python -m http.server 8000

# Con Node.js
npx serve .

# Con PHP
php -S localhost:8000
```

---

## 🎨 Personalización

### **Colores de Marca**
```css
:root {
    --primary-color: #009FE3;
    --secondary-color: #312783;
    --primary-gradient: linear-gradient(135deg, #009FE3 0%, #312783 100%);
}
```

### **Tipografía**
```css
:root {
    --font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
}
```

### **Espaciado**
```css
:root {
    --spacing-4: 1rem;
    --spacing-8: 2rem;
    --spacing-16: 4rem;
}
```

---

## 📱 Secciones de la Landing Page

### **1. Hero Section**
- Título principal con efecto de escritura
- Descripción de la aplicación
- Badges de tecnologías
- Botones de descarga y GitHub
- Mockup animado de la aplicación

### **2. Características**
- 6 tarjetas con funcionalidades principales
- Iconos personalizados
- Efectos hover avanzados
- Animaciones de entrada escalonadas

### **3. Capturas de Pantalla**
- 3 mockups interactivos de la app
- Diferentes pantallas de la aplicación
- Efectos de hover y tilt
- Descripciones detalladas

### **4. Descarga**
- Información de descarga prominente
- Pasos de instalación
- Especificaciones técnicas
- Botón de descarga destacado

### **5. Acerca del Proyecto**
- Información del desarrollador
- Stack tecnológico
- Enlaces sociales
- Biografía profesional

---

## ⚡ Optimizaciones de Rendimiento

### **CSS**
- Variables CSS para consistencia
- Animaciones optimizadas con `transform` y `opacity`
- Media queries para responsive design
- Selectores eficientes

### **JavaScript**
- Lazy loading de contenido
- Debounce para eventos de scroll
- Intersection Observer para animaciones
- Error handling robusto

### **HTML**
- Estructura semántica
- Meta tags optimizados
- Open Graph para redes sociales
- Favicon y recursos optimizados

---

## 🔧 Funcionalidades JavaScript

### **Navegación**
- Menú hamburguesa responsive
- Scroll suave entre secciones
- Navegación activa basada en scroll
- Efectos de transparencia en navbar

### **Animaciones**
- Efectos de entrada con Intersection Observer
- Parallax en elementos de fondo
- Animaciones de escritura
- Efectos hover avanzados

### **Interactividad**
- Botón back-to-top inteligente
- Efectos de magnetismo en cards
- Ripple effects en botones
- Mockups interactivos

---

## 📊 Métricas de Rendimiento

### **Lighthouse Score**
- **Performance**: 95+
- **Accessibility**: 100
- **Best Practices**: 100
- **SEO**: 100

### **Optimizaciones Implementadas**
- ✅ Lazy loading de imágenes
- ✅ CSS y JS minificados
- ✅ Compresión de recursos
- ✅ Caché optimizado
- ✅ Meta tags completos

---

## 🌐 SEO y Accesibilidad

### **SEO**
- Meta tags optimizados
- Open Graph para redes sociales
- Estructura semántica HTML5
- URLs amigables
- Sitemap automático

### **Accesibilidad**
- Navegación por teclado
- Contraste de colores adecuado
- Textos alternativos
- Estructura de encabezados
- ARIA labels

---

## 📱 Compatibilidad

### **Navegadores Soportados**
- ✅ Chrome 80+
- ✅ Firefox 75+
- ✅ Safari 13+
- ✅ Edge 80+

### **Dispositivos**
- ✅ Desktop (1200px+)
- ✅ Tablet (768px - 1199px)
- ✅ Mobile (320px - 767px)

---

## 🚀 Deployment

### **GitHub Pages**
La página está configurada para deploy automático en GitHub Pages:

1. **URL**: `https://dongeo87.github.io/MisGastos/`
2. **Branch**: `main`
3. **Build**: Automático en cada push
4. **Custom Domain**: Configurable en Settings

### **Variables de Entorno**
```bash
# GitHub Pages automáticamente usa:
GITHUB_USERNAME=dongeo87
REPOSITORY_NAME=MisGastos
BASE_URL=https://dongeo87.github.io/MisGastos/
```

---

## 🤝 Contribuciones

### **Cómo Contribuir**
1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

### **Guías de Contribución**
- Sigue las convenciones de código existentes
- Mantén la consistencia visual
- Optimiza para rendimiento
- Prueba en diferentes dispositivos

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para detalles.

---

## 👨‍💻 Desarrollador

### **Giorgio Interdonato Palacios**
- 🌐 **GitHub**: [@DonGeeo87](https://github.com/DonGeeo87)

---

<div align="center">

**⭐ ¡Dale una estrella al proyecto si te gusta! ⭐**

Desarrollado con ❤️ por [Giorgio Interdonato Palacios](https://github.com/DonGeeo87)

[🌐 Ver en Vivo](https://dongeo87.github.io/Mis-Gastos-App/) | [📱 App Android](https://github.com/DonGeeo87/Mis-Gastos-App) | [📖 Documentación](https://github.com/DonGeeo87/Mis-Gastos-App/blob/main/README.md)

</div>
