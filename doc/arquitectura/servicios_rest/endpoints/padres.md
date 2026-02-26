# 👨‍👩‍👧 Documentación de la API: Módulo Padres y Tutores

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Perfil-Familia-6366f1?style=for-the-badge" />

<br>

El endpoint de **Padres** gestiona la información de los tutores legales de los alumnos en Enlace Pro. Su función principal es servir de puente para la comunicación y el seguimiento del progreso del estudiante. Al estar vinculado directamente con el `id_alumno`, este módulo permite que los padres reciban información personalizada y reportes traducidos a su idioma de preferencia, facilitando su involucración en el proceso educativo.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. Especificaciones Técnicas del Endpoint

A continuación se detallan los métodos para la administración de los perfiles de tutores legales y su vinculación con los estudiantes.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/padres` | **GET** | N/A | `200` | Listado de padres/tutores | `PadreNotFound` |
| `/padres` | **POST** | `{"nombre":"...", "id_alumno":3}` | `201` | Registro de tutor creado | `400: Bad Request` |
| `/padres/{id}` | **GET** | N/A | `200` | Ficha de contacto del tutor | `404: Not Found` |
| `/padres/{id}` | **PUT** | `{"nombre":"...", "telefono":"..."}` | `200` | Datos de contacto actualizados | `400, 404` |
| `/padres/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. Gestión del Vínculo Familiar

La administración de los perfiles de familia se organiza en **tres fases clave** para garantizar que el flujo de información sea seguro y directo.



### Fase A: Registro y Parentesco
Al dar de alta a un tutor mediante **POST**, el sistema requiere obligatoriamente un `id_alumno`. Esta relación es la que permite que, en el futuro, cuando un profesor genere un informe de progreso, el sistema sepa automáticamente a qué correo electrónico o teléfono debe enviar la notificación, asegurando que la familia esté siempre al tanto de la evolución del menor.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase B: Canal de Comunicación Activo
El método **GET** permite a los administradores y profesores acceder rápidamente a los datos de contacto de la familia. En contextos de Aulas de Enlace, donde la coordinación con los padres es vital para la integración del alumno, disponer de esta información de forma centralizada y actualizada es esencial para resolver cualquier incidencia de forma inmediata.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase C: Actualización de Datos de Contacto
Mediante los métodos **PUT** y **DELETE**, el sistema se adapta a los cambios en la situación familiar. Si una familia cambia de número de teléfono o de correo electrónico, los datos pueden actualizarse al instante. Esto garantiza que el canal de comunicación nunca se rompa y que los reportes de evaluación PDF lleguen siempre a su destino correcto.

---

  <br>
  <img src="https://img.shields.io/badge/Privacidad-RGPD_Ready-success?style=flat-square" />
  <img src="https://img.shields.io/badge/Relación-One--to--Many-blue?style=flat-square" />