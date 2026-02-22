 # 🚀 Servicios REST: Arquitectura de Roles

  <img src="https://img.shields.io/badge/Architecture-REST_API-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Security-Role_Based_Access-red?style=for-the-badge&logo=springsecurity" />

<br>

Enlace Pro utiliza una arquitectura de servicios orientada a recursos, donde cada entidad se gestiona a través de endpoints específicos. Para garantizar la seguridad y la integridad de los datos académicos, hemos implementado un sistema de **Control de Acceso Basado en Roles (RBAC)**, donde cada perfil tiene acceso solo a las funciones CRUD necesarias para su labor.

---

## 1. Matriz de Acceso y Funcionalidades

No todos los usuarios interactúan de la misma forma con la base de datos. A continuación, se detalla la disponibilidad de operaciones según el endpoint:

| 🧩 Endpoint | 👤 Rol Principal | 🛠️ Operaciones CRUD | ✨ Propósito |
| :--- | :--- | :---: | :--- |
| **[/alumnos](endpoints/alumnos.md)** | Directores / Profesores | `Full CRUD` | Gestión de expedientes y niveles. |
| **[/profesores](endpoints/profesores.md)** | Directores | `Full CRUD` | Administración del equipo docente. |
| **[/idiomas](endpoints/idiomas.md)** | Directores | `GET / POST` | Escalabilidad lingüística del sistema. |
| **[/padres](endpoints/padres.md)** | Profesores / Directores | `Full CRUD` | Gestión de comunicación familiar. |
| **[/directores](endpoints/directores.md)** | Administrador Sistema | `Full CRUD` | Control de alto nivel del centro. |

---

## 2. Implementación de la Lógica de Negocio

La comunicación entre el cliente y el servidor se rige por **estos principios técnicos** fundamentales:



### Fase A: Desacoplamiento (RESTful)
Cada endpoint funciona de manera independiente. Esto significa que podemos actualizar la lógica de los profesores sin afectar al funcionamiento de los idiomas o los contenidos. El servidor responde exclusivamente en formato **JSON**, lo que permite que la interfaz sea ligera y rápida.

---

### Fase B: Seguridad en el Acceso (RBAC)
A través de **Spring Security**, cada petición HTTP es validada. Si un usuario con rol "Padre" intenta realizar una petición `POST` al endpoint de `/profesores`, el sistema denegará automáticamente el acceso con un error `403 Forbidden`, protegiendo la jerarquía y privacidad del centro.

---

### Fase C: Consistencia de Datos
Aunque cada endpoint tiene su propia implementación, todos comparten un sistema común de manejo de excepciones. Si un recurso no se encuentra, la API devuelve una respuesta estandarizada (ej. `AlumnoNotFoundException`), facilitando que el frontend informe al usuario de manera clara y coherente.

---

En nuestra aplicación web tendremos los siguientes roles:

- [Endpoint /alumnos](endpoints/alumnos.md)
- [Endpoint /profesores](endpoints/profesores.md)
- [Endpoint /idiomas](endpoints/idiomas.md)
- [Endpoint /padres](endpoints/padres.md)
- [Endpoint /directores](endpoints/directores.md)

  <br>
  <img src="https://img.shields.io/badge/Backend-Spring_Boot_3-green?style=flat-square&logo=springboot" />
  <img src="https://img.shields.io/badge/Docs-Markdown_Linked-gray?style=flat-square" />