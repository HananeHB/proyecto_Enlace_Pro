# 🖼️ Documentación de la API: Módulo Imágenes

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Recursos-Multimedia-f472b6?style=for-the-badge" />

<br>

Este endpoint gestiona los recursos visuales de Enlace Pro. Dado que nuestra aplicación está enfocada a Aulas de Enlace, el soporte visual es fundamental para que los alumnos asocien conceptos de forma rápida. A través de esta API, controlamos la subida, actualización y listado de las imágenes que acompañan al vocabulario y a los materiales didácticos.

---

## 1. Especificaciones Técnicas del Endpoint

La siguiente tabla detalla las operaciones disponibles para la gestión de archivos y rutas de imagen en el servidor.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/imagenes` | **GET** | N/A | `200` | Lista de todas las imágenes | `ImagenNotFound` |
| `/imagenes` | **POST** | `{"imagen":"gato.webp"}` | `201` | Datos de la imagen registrada | `400: Bad Request` |
| `/imagenes/{id}` | **GET** | N/A | `200` | Detalle de la imagen única | `404: Not Found` |
| `/imagenes/{id}` | **PUT** | `{"imagen":"naranja.jpg"}` | `200` | Nombre de imagen actualizado | `400, 404` |
| `/imagenes/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

---

## 2. Gestión de Recursos Visuales

El manejo de imágenes en Enlace Pro se divide en **tres fases críticas** para asegurar que el contenido multimedia se sirva correctamente en la interfaz.

### Fase A: Registro de Rutas
Cuando un profesor sube o referencia una nueva imagen, el sistema procesa la petición **POST**. No solo se guarda el nombre del archivo, sino que se valida que el formato sea compatible (como `.png`, `.jpg` o `.webp`) para asegurar que se visualice correctamente en los paneles de cristal de la web.

---

### Fase B: Vinculación con el Aprendizaje
Las imágenes no están aisladas; cada `id_imagen` se relaciona posteriormente con términos de vocabulario. A través de las peticiones **GET**, el frontend recupera la ruta del archivo y la renderiza dinámicamente, permitiendo que el alumno vea la imagen asociada a la palabra que está aprendiendo en su idioma.

---

### Fase C: Mantenimiento y Limpieza
Mediante los métodos **PUT** y **DELETE**, el administrador puede corregir nombres de archivos o eliminar recursos que ya no se utilicen. Esto mantiene el servidor ligero y organizado, evitando que queden archivos huérfanos que no estén asociados a ningún contenido educativo real.

---

  <br>
  <img src="https://img.shields.io/badge/Formatos-WebP_PNG_JPG-gray?style=flat-square" />
  <img src="https://img.shields.io/badge/Almacenamiento-Optimizado-success?style=flat-square" />