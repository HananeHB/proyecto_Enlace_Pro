# 👥 Documentación de la API: Módulo Alumnos

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Gestión-Estudiantes-0ea5e9?style=for-the-badge" />

<br>

El endpoint de **Alumnos** es el pilar administrativo de Enlace Pro. Se encarga de gestionar el ciclo de vida de los estudiantes en el Aula de Enlace, almacenando no solo sus datos de contacto, sino también su vinculación familiar y lingüística. Esta información es la que permite al sistema adaptar automáticamente los contenidos y enviar las notificaciones correspondientes a los tutores legales.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. Especificaciones Técnicas del Endpoint

A continuación se detallan los métodos para la administración de los expedientes digitales de los alumnos.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/alumnos` | **GET** | N/A | `200` | Listado completo de alumnos | `AlumnoNotFound` |
| `/alumnos` | **POST** | `{"nombre":"...", "id_padre":1}` | `201` | Registro del alumno creado | `400: Bad Request` |
| `/alumnos/{id}` | **GET** | N/A | `200` | Ficha individual del alumno | `404: Not Found` |
| `/alumnos/{id}` | **PUT** | `{"nombre":"...", "telefono":"..."}` | `200` | Datos de contacto actualizados | `400, 404` |
| `/alumnos/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. Ciclo de Gestión del Estudiantado

La administración de alumnos se organiza en **las siguientes fases clave** para garantizar que cada estudiante tenga un entorno configurado a su medida.



### Fase A: Alta y Vinculación
Cuando se registra un nuevo alumno mediante **POST**, el sistema genera un identificador único (ID) y establece las relaciones necesarias con su idioma de origen (`id_idioma`) y su tutor legal (`id_padre`). Este paso es fundamental para que, desde el primer acceso, la interfaz "Liquid Glass" sepa en qué idioma debe mostrarse.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase B: Consulta y Seguimiento
El método **GET** permite a los profesores y directores acceder a las fichas de los alumnos. Gracias a la integración con el sistema de **Generación de Reportes**, estos datos se utilizan para rellenar automáticamente los documentos PDF, evitando que el profesorado tenga que transcribir manualmente nombres o teléfonos.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase C: Mantenimiento de Datos
A través de **PUT** y **DELETE**, se garantiza que la base de datos esté siempre actualizada. Si un alumno cambia de número de teléfono o abandona el centro, el personal administrativo puede reflejar el cambio al instante, manteniendo la integridad de la comunicación entre el instituto y las familias.

---

  <br>
  <img src="https://img.shields.io/badge/Seguridad-Datos_Protegidos-success?style=flat-square" />
  <img src="https://img.shields.io/badge/Relación-Alumno--Familia-blue?style=flat-square" />