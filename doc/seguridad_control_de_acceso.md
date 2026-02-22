#  Seguridad y Control de Acceso


  <img src="https://img.shields.io/badge/Protección-Activa-success?style=for-the-badge&logo=guardant" />
  <img src="https://img.shields.io/badge/Privacidad-Garantizada-blue?style=for-the-badge" />


<br>

Esta documentación describe como el sistema controla quién puede acceder y qué acciones puede realizar cada usuario, evitando accesos no permitidos. Además, la aplicación tiene en cuenta el uso de diferentes idiomas, para que todas las personas puedan utilizarla con mayor facilidad. De esta forma, el sistema no solo protege la aplicación, sino que tambień ayuda a que la experiencia del usuario sea más fácil y cómoda.

---

## 🛡️ 1. Gestión de Usuarios y Roles

El sistema utiliza un control de acceso basado en roles. Esto significa que cada usuario tiene un rol asignado y, según ese rol, puede acceder a unas funciones u otras dentro de la aplicación web. También se tiene en cuenta ciertos datos del usuario, como su nivel de español o su idioma materno, para mostrarle el contenido adecuado.



| 👤 Usuario | 🏷️ Rol | 🔑 Permisos Principales |
| :--- | :---: | :--- |
| **Director** | `Admin` | Controlar a todo el personal. Puede añadir o borrar alumnos y profesores. También es el único que puede agregar nuevos idiomas al sistema. |
| **Profesor** | `User` | Crear, eliminar contenido y modificar niveles de competencia. |
| **Alumno** | `User` | Acceso a material educativo adaptado donde aprende mediante contenido filtrado por su nivel de competencia. |
| **Padre/Tutor** | `User` | Consulta de reportes y notificaciones personalizadas con el objetivo de mantenerse informado del progreso de su hijo. |

---

## ⚙️ 2. Funcionamiento del Sistema de Seguridad

La seguridad de EnlacePro se organiza en **tres pasos principales** para asegurar un uso correcto de la aplicación.

### 🏛️ Fase A: Autenticación de Identidad
Es el primer paso para entrar en la aplicación. Una vez elegido que tipo de usuario (director, profesor, alumno, padre/tutor) el sistema valida las credenciales (email / contraseña).

> 🔐 **Cifrado de Seguridad:** Para proteger la información, las contraseñas no se guardan en texto plano, sino que se almacenan utilizando un **hash**, que transforma la contraseña en un valor cifrado y no reversible. De este modo, se garantiza la seguridad de los datos personales y el cumplimiento de la normativa de protección de datos.

Una vez validado, cada usuario accede al sistema con unos **permisos ya definidos según su tipo de usuario o rol.**

---

###  Fase B: Preparación del Entorno
Una vez que el usuario ha iniciado sesión, el sistema adapta la aplicación a su **idioma** y **nivel de competencia**. Así, cada usuario ve contenidos adecuados y traducidos si hace falta.

---

###  Fase C: Autorización de Acciones
Cada vez que el usuario realiza una acción, el sistema comprueba que su **rol tenga permiso** para hacerla, protegiendo los datos y funciones sensibles.

---


  <br>
  <img src="https://img.shields.io/badge/Tecnología_Base-Spring_Security-green?style=flat-square&logo=spring" />
  <img src="https://img.shields.io/badge/Auth-JWT_Tokens-black?style=flat-square&logo=jsonwebtokens" />



