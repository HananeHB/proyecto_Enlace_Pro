# 📕 Documentación de la API: Módulo Vocabulario

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Aprendizaje-Léxico-FF9800?style=for-the-badge" />

<br>

El endpoint de **Vocabulario** gestiona el léxico fundamental de la aplicación. Su función principal es servir como puente entre las palabras que el alumno debe aprender y los recursos visuales que facilitan su comprensión. Este módulo permite organizar el vocabulario por unidades temáticas o niveles de competencia, siendo una herramienta esencial para el trabajo diario en el Aula de Enlace.

---

## 1. Especificaciones Técnicas del Endpoint

A continuación se detallan las operaciones disponibles para gestionar el banco de palabras y sus asociaciones multimedia.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/vocabulario` | **GET** | N/A | `200` | Lista de términos registrados | `VocabularioNotFound` |
| `/vocabulario` | **POST** | `{"vocabulario":"...", "id_imagen":15}` | `201` | Datos del término creado | `400: Bad Request` |
| `/vocabulario/{id}` | **GET** | N/A | `200` | Detalle del término único | `404: Not Found` |
| `/vocabulario/{id}` | **PUT** | `{"vocabulario":"...", "id_imagen":6}` | `200` | Término actualizado | `400, 404` |
| `/vocabulario/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

---

## 2. Ciclo de Vida del Aprendizaje Léxico

La gestión del vocabulario en Enlace Pro se organiza en **tres fases operativas** para garantizar que los alumnos dispongan de materiales claros y bien estructurados.



### Fase A: Registro y Asociación Visual
Mediante las peticiones **POST**, el profesorado puede dar de alta nuevos términos. Una característica clave es la vinculación con el `id_imagen`; esto asegura que, desde el momento de su creación, la palabra (ej. *"Gato"*) esté ligada a un soporte visual que refuerce el aprendizaje por asociación, algo vital en las primeras etapas de adquisición del español.

---

### Fase B: Consulta y Consumo de Datos
El método **GET** es utilizado por el frontend para poblar las actividades interactivas. El sistema devuelve un listado en formato JSON que contiene tanto el término como la referencia a su imagen, permitiendo que la interfaz "Liquid Glass" presente las tarjetas de vocabulario de forma dinámica y atractiva para el estudiante.

---

### Fase C: Actualización del Diccionario
A través de los métodos **PUT** y **DELETE**, el sistema permite mantener un léxico preciso. Si una imagen debe ser actualizada por una de mejor calidad o un término debe ser modificado para ajustarse mejor al nivel del aula, el profesor puede realizar los cambios sin afectar a la integridad del resto de los módulos.

---

  <br>
  <img src="https://img.shields.io/badge/Estructura-JSON_Array-gray?style=flat-square" />
  <img src="https://img.shields.io/badge/Asociación-Léxico--Imagen-blue?style=flat-square" />