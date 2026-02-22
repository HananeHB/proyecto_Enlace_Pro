# 📊 Documentación de la API: Módulo Informes

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Datos-Evaluación-green?style=for-the-badge" />

<br>

Este endpoint es fundamental para el seguimiento académico en Enlace Pro. Se encarga de gestionar el contenido de los reportes y evaluaciones que los docentes generan para monitorizar el progreso de los alumnos. Estos datos sirven como base para la posterior generación de documentos oficiales y comunicaciones con las familias.

---

## 1. Especificaciones Técnicas del Endpoint

La tabla a continuación describe las operaciones CRUD disponibles para la gestión de la base documental de los informes.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/informes` | **GET** | N/A | `200` | Lista de todos los informes | `InformeNotFound` |
| `/informes` | **POST** | `{"contenido":"..."}` | `201` | Datos del informe creado | `400: Bad Request` |
| `/informes/{id}` | **GET** | N/A | `200` | Detalle del informe único | `404: Not Found` |
| `/informes/{id}` | **PUT** | `{"contenido":"..."}` | `200` | Contenido actualizado | `400, 404` |
| `/informes/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

---

## 2. Flujo de Gestión de Reportes

La administración de informes en Enlace Pro se organiza en **tres fases operativas** que garantizan la integridad de la información académica.



### Fase A: Registro de Evaluaciones
A través de las peticiones **POST**, el profesorado puede volcar las observaciones y evaluaciones de cada alumno en el sistema. El cuerpo de la petición acepta el contenido textual que luego será procesado, asegurando que la información quede guardada de forma segura en la base de datos de Spring Boot.

---

### Fase B: Consulta y Recuperación
El método **GET** permite recuperar informes específicos para su visualización en los paneles "Liquid Glass" de la interfaz. Esta fase es clave para las reuniones de evaluación, donde el docente necesita acceder rápidamente al historial de progreso del estudiante sin demoras.

---

### Fase C: Actualización y Depuración
Mediante **PUT** y **DELETE**, se mantiene la calidad de la documentación. Los profesores pueden corregir anotaciones en informes existentes o eliminar borradores que ya no sean necesarios, manteniendo el sistema limpio y centrado exclusivamente en la información relevante para el expediente del alumno.

---

  <br>
  <img src="https://img.shields.io/badge/Persistencia-JPA_Hibernate-orange?style=flat-square" />
  <img src="https://img.shields.io/badge/Salida-JSON_Stream-gray?style=flat-square" />