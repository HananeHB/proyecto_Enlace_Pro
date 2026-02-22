# 👨‍💼 Documentación de la API: Módulo Directores

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Perfil-Administrador-red?style=for-the-badge" />

<br>

El endpoint de **Directores** gestiona las cuentas de los usuarios con rol de administración superior en Enlace Pro. Estos perfiles no solo supervisan la actividad académica, sino que también están vinculados a materias específicas o áreas de gestión del instituto. Es el módulo encargado de garantizar que los responsables del centro tengan sus credenciales y datos de contacto siempre actualizados.

---

## 1. Especificaciones Técnicas del Endpoint

A continuación se detallan las operaciones para administrar los perfiles de dirección y su vinculación con las áreas docentes.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/directores` | **GET** | N/A | `200` | Listado de directores | `DirectorNotFound` |
| `/directores` | **POST** | `{"nombre":"...", "id_materia":1}` | `201` | Registro de director creado | `400: Bad Request` |
| `/directores/{id}` | **GET** | N/A | `200` | Ficha técnica del director | `404: Not Found` |
| `/directores/{id}` | **PUT** | `{"nombre":"...", "id_materia":1}` | `200` | Perfil actualizado | `400, 404` |
| `/directores/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

---

## 2. Gestión de Altas y Atribuciones

La administración de los perfiles de dirección se organiza en **las siguientes fases críticas** para asegurar el control total sobre la plataforma.



### Fase A: Registro y Asignación de Materia
Al crear un perfil mediante **POST**, el sistema vincula al director con una materia o departamento (`id_materia`). Esto es clave para que, al acceder a la interfaz, el sistema pueda filtrar qué informes o datos son más relevantes para su perfil específico dentro de la estructura organizativa del instituto.

---

### Fase B: Acceso a la Gestión Global
El método **GET** permite recuperar la información de contacto y profesional de los directores. Al ser el rol con más peso, el sistema utiliza estos datos para validar que las acciones críticas (como el borrado de alumnos o la creación de nuevos idiomas en el módulo i18n) sean realizadas por la persona correcta.

---

### Fase C: Actualización de Responsabilidades
A través de **PUT**, se pueden modificar las atribuciones de un director, como su cambio de departamento o la actualización de sus datos de contacto. El método **DELETE** se reserva para la revocación de accesos, asegurando que si un miembro del equipo directivo abandona el centro, su acceso sea eliminado de forma segura y eficiente.

---

  <br>
  <img src="https://img.shields.io/badge/Acceso-Root_Admin-black?style=flat-square" />
  <img src="https://img.shields.io/badge/Validación-JPA_Entity-orange?style=flat-square" />