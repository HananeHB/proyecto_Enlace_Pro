# 📖 Documentación de la API: Módulo Textos

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Contenido-Lectura-E91E63?style=for-the-badge" />

<br>

Este endpoint centraliza la gestión de los recursos textuales de Enlace Pro. Su función es almacenar y proporcionar las frases, enunciados y textos adaptados que se utilizan en las actividades didácticas. Es el motor que alimenta la comprensión lectora de los estudiantes, permitiendo una progresión lógica desde frases sencillas hasta estructuras más complejas.

---

## 1. Especificaciones Técnicas del Endpoint

La tabla a continuación detalla los métodos disponibles para interactuar con la base de datos de textos educativos.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/textos` | **GET** | N/A | `200` | Lista de todos los textos | `TextoNotFound` |
| `/textos` | **POST** | `{"texto":"..."}` | `201` | Datos del texto creado | `400: Bad Request` |
| `/textos/{id}` | **GET** | N/A | `200` | Detalle del texto único | `404: Not Found` |
| `/textos/{id}` | **PUT** | `{"texto":"..."}` | `200` | Contenido actualizado | `400, 404` |
| `/textos/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

---

## 2. Flujo de Gestión de Contenido Lectivo

La administración de los textos en Enlace Pro sigue **tres pasos operativos** para garantizar que el material educativo esté siempre disponible y actualizado.

### Fase A: Creación de Material Adaptado
A través de las peticiones **POST**, los docentes pueden introducir nuevos textos adaptados al nivel de competencia de sus alumnos. El sistema valida la entrada y asigna un identificador único, permitiendo que las frases queden registradas para su uso inmediato en la plataforma.

---

### Fase B: Recuperación Dinámica
El método **GET** permite al frontend extraer los textos necesarios para cada ejercicio. Gracias a la integración con el diseño "Liquid Glass", estas frases se presentan de forma clara y espaciada, facilitando que el alumno pueda centrarse en la lectura sin distracciones visuales.

---

### Fase C: Optimización y Edición
Mediante los métodos **PUT** y **DELETE**, el profesorado puede refinar el contenido. Si un texto necesita ser simplificado o corregido para mejorar la comprensión, se actualiza mediante una petición PUT, asegurando que todos los alumnos vean la versión mejorada al instante.

---

  <br>
  <img src="https://img.shields.io/badge/Formato-UTF--8-gray?style=flat-square" />
  <img src="https://img.shields.io/badge/Lógica-CRUD_Textos-blue?style=flat-square" />