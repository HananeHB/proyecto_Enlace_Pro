# 🧩 Motor de Vistas: Thymeleaf y Fragmentos

  <img src="https://img.shields.io/badge/Engine-Thymeleaf_3.0-005f00?style=for-the-badge&logo=thymeleaf" />
  <img src="https://img.shields.io/badge/Architecture-Modular-blue?style=for-the-badge" />

<br>

Esta documentación explica cómo gestionamos la generación de vistas de forma eficiente en Enlace Pro. Utilizamos **Thymeleaf** como motor de plantillas del lado del servidor, aplicando un enfoque modular basado en fragmentos. Esto nos permite separar la estructura general de la aplicación del contenido específico de cada página, facilitando el mantenimiento y evitando la duplicidad de código.

---

## 🧱 1. Modularización y Componentes Reutilizables

En lugar de crear páginas enteras desde cero, hemos dividido la interfaz en piezas independientes que se ensamblan según la necesidad de cada vista.

| 🧩 Fragmento | 🏷️ Ubicación | ✨ Función Principal |
| :--- | :---: | :--- |
| **`EnlacePro_main.html`** | `layout` | El esqueleto base que organiza dónde va cada componente. |
| **`sidebar.html`** | `aside` | Panel lateral con navegación y acceso a futuros roles de usuario y boton de cerrar sesión. |
| **`header.html`** | `header` | Barra superior con buscador, notificaciones, mensaje de bienvenida para el usuario, botón de cambio de idioma (I18N) y modo claro/oscuro. |
| **`contenido_central.html`** | `content` | Variable la cual cambia dependiendo de la página a la que accedamos desde el menú.|


---

## ⚙️ 2. Funcionamiento de la Arquitectura Modular

La construcción de las páginas en Enlace Pro sigue **tres pasos principales** para asegurar que el código esté limpio y sea fácil de actualizar.

### Fase A: Definición del Layout
El archivo `layout.html` actúa como la base de todo el proyecto. En este archivo configuramos las etiquetas globales, como las fuentes de Google, las librerías de Tailwind y los scripts de JavaScript. Gracias a la etiqueta `th:replace`, este esqueleto "llama" a las partes necesarias sin tener que repetir el código en cada página nueva.

> 💡 **Mantenimiento Único:** Si necesitamos añadir un nuevo estilo o una librería (como Chart.js), solo tenemos que hacerlo en el layout y automáticamente estará disponible en toda la aplicación, ahorrando tiempo y evitando errores.

---

### Fase B: Inyección Dinámica de Contenido
Cada página específica (como la lista de alumnos o el calendario) solo contiene el código que le corresponde. Al cargar la página, el sistema utiliza el atributo `th:replace="${content} :: content"` para inyectar la lógica propia de esa vista dentro del diseño general, manteniendo siempre el Sidebar y el Header intactos.

---

### Fase C: Integración con Spring Boot
Thymeleaf nos permite conectar directamente el servidor con la interfaz. A través de etiquetas como `th:text` o `th:each`, mostramos de forma dinámica los datos que vienen de la base de datos (nombres de alumnos, mensajes traducidos, etc.) de una manera sencilla y totalmente integrada con la lógica de negocio de Spring.

---

  <br>
  <img src="https://img.shields.io/badge/Server_Side-Java_Spring-green?style=flat-square&logo=springboot" />
  <img src="https://img.shields.io/badge/Templates-HTML5_Fragments-orange?style=flat-square" />