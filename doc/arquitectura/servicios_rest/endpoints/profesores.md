# 👩‍🏫 Documentación de la API: Módulo Profesores

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Perfil-Docente-7c3aed?style=for-the-badge" />

<br>

El endpoint de **Profesores** gestiona las cuentas de los docentes encargados de las Aulas de Enlace. Este perfil es fundamental, ya que tiene los permisos necesarios para interactuar con los módulos de vocabulario, textos y la generación de informes. A través de esta API, el sistema asegura que cada profesor tenga sus datos de contacto actualizados y pueda ser identificado correctamente en los reportes que genera.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. Especificaciones Técnicas del Endpoint

A continuación se detallan las operaciones CRUD disponibles para la administración del personal docente.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/profesores` | **GET** | N/A | `200` | Listado de profesores | `ProfesorNotFound` |
| `/profesores` | **POST** | `{"nombre":"...", "email":"..."}` | `201` | Registro de profesor creado | `400: Bad Request` |
| `/profesores/{id}` | **GET** | N/A | `200` | Ficha individual del docente | `404: Not Found` |
| `/profesores/{id}` | **PUT** | `{"nombre":"...", "telefono":"..."}` | `200` | Datos de contacto actualizados | `400, 404` |
| `/profesores/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. Gestión del Cuerpo Docente

La administración de los perfiles de profesorado se organiza en **tres fases operativas** para garantizar un flujo de trabajo eficiente dentro del centro.



### Fase A: Registro y Habilitación
Mediante la petición **POST**, el administrador o el equipo directivo puede dar de alta a nuevos profesores en el sistema. Al registrar su email y teléfono, el docente queda habilitado para acceder a la plataforma y comenzar a gestionar sus respectivos grupos de alumnos, integrándose automáticamente en el ecosistema de Enlace Pro.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase B: Identificación en Reportes
El método **GET** permite recuperar la información del docente para personalizar la interfaz "Liquid Glass". Es una fase clave para la **Generación de Reportes PDF**, ya que el sistema utiliza estos datos para firmar automáticamente los informes de progreso y las fichas de los alumnos, dando validez oficial a los documentos generados.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase C: Actualización y Seguridad
A través de **PUT** y **DELETE**, el sistema permite mantener la base de datos del personal al día. Si un profesor cambia su número de contacto o termina su periodo en el Aula de Enlace, los datos pueden modificarse o eliminarse al instante, asegurando que el acceso a la información sensible de los alumnos esté siempre en las manos correctas.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


  <br>
  <img src="https://img.shields.io/badge/Rol-User_Docente-blue?style=flat-square" />
  <img src="https://img.shields.io/badge/Entidad-Spring_Data_JPA-green?style=flat-square&logo=springboot" />