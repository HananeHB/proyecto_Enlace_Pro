#  Seguridad: Spring Security + JWT

 <img src="https://img.shields.io/badge/Security-Stateless-blue?style=for-the-badge&logo=springsecurity" />
  <img src="https://img.shields.io/badge/Token-JWT-black?style=for-the-badge&logo=jsonwebtokens" />
  <img src="https://img.shields.io/badge/Database-MariaDB-white?style=for-the-badge&logo=mariadb" />

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  1. Flujo de Autenticación (Login)

Enlace Pro implementa un modelo de seguridad basado en **tokens sin estado (Stateless)**, lo cual es fundamental en arquitecturas de microservicios para garantizar que la identidad del usuario viaje con cada petición sin necesidad de sesiones en el servidor.



1. **Petición de Login**: El usuario envía sus credenciales al microservicio `auth-service`.
2. **Validación**: El servicio comprueba el usuario y la contraseña en la base de datos **MariaDB**.
3. **Generación del Token**: Si son correctos, se genera un **JSON Web Token (JWT)** firmado digitalmente que contiene:
   * 🆔 **Subject**: Identificador del usuario.
   * 🏷️ **Claims**: Roles y permisos (ej. `ROLE_PROFESOR`, `ROLE_ADMIN`).
   * ⏳ **Expiration**: Tiempo de validez del token.
4. **Respuesta**: El servidor devuelve el token al cliente (navegador/Postman).

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  2. Flujo de Autorización (Peticiones)

Para cualquier petición protegida (ej. ver alumnos), el cliente debe incluir el token en la cabecera de la solicitud bajo el campo **Authorization** con el prefijo **Bearer**.

El **Filtro de Seguridad** (`JwtFilter`) en la capa de infraestructura intercepta la petición, valida la firma del token y carga los permisos en el contexto de **Spring Security** de forma automática.



<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  3. Roles y Permisos (RBAC)

Hemos implementado un sistema de **Control de Acceso Basado en Roles**:

| 🔑 Rol | 🛠️ Alcance y Permisos |
| :--- | :--- |
| **ADMIN** | Acceso total al sistema y gestión de usuarios. |
| **PROFESOR** | Gestión de alumnos, idiomas y exportación de reportes. |
| **INVITADO** | Acceso de solo lectura a recursos limitados. |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 🛠️ Detalles Técnicos y Configuración

<details>
<summary><b>📖 Documentación de API (Swagger)</b></summary>
<br>
<blockquote>
  <b>Nota Técnica:</b> La seguridad está configurada para permitir el acceso libre a los endpoints de Swagger para facilitar la fase de desarrollo y testeo.
</blockquote>
</details>

<details>
<summary><b>🛡️ Persistencia de Seguridad</b></summary>
<br>
El microservicio de seguridad se apoya en una base de datos <b>MariaDB</b> dedicada, aislando las credenciales de la lógica de negocio para cumplir con los principios de microservicios.
</details>

