#  Arquitectura del Ecosistema Distribuido

 <img src="https://img.shields.io/badge/Infraestructura-Docker_Compose-blue?style=for-the-badge&logo=docker" />
  <img src="https://img.shields.io/badge/Bases_Datos-Persistentes-green?style=for-the-badge" />
  
La aplicación **Enlace Pro** ha evolucionado de un modelo monolítico a una **arquitectura de microservicios distribuida**. Ahora, el sistema no depende de una sola pieza, sino de un conjunto de contenedores que trabajan de forma coordinada para ofrecer mayor seguridad y escalabilidad.

Esta arquitectura se divide en tres niveles: **Puerta de Entrada (Gateway), Lógica de Negocio (Microservicios) y Persistencia (Bases de Datos Externas)**.



<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. El punto de entrada: API Gateway
En esta nueva etapa, el usuario no contacta directamente con los servicios finales. Todo pasa por el **API Gateway** (puerto 8080):

* **Punto Único de Acceso:** El cliente (navegador/Postman) solo conoce una dirección.
* **Enrutamiento Inteligente:** El Gateway recibe la solicitud y, según la URL (`/auth/**` o `/alumnos/**`), la redirige al microservicio correspondiente.
* **Seguridad Centralizada:** Actúa como el primer filtro de seguridad para las peticiones externas.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. El motor del sistema: Docker y JVM

A diferencia de la versión anterior, cada componente vive dentro de un **Contenedor Docker**, lo que garantiza que la app funcione igual en cualquier ordenador.

1. **Docker Engine:** Gestiona los contenedores, aislando los recursos y permitiendo que MySQL, MariaDB y los microservicios convivan sin conflictos.
2. **Java Virtual Machine (JVM):** Cada microservicio (`Auth` y `Alumnos`) corre su propia JVM optimizada. Se han configurado límites de memoria y conteo de hilos (`BPL_JVM_THREAD_COUNT`) para asegurar la estabilidad del sistema.
3. **Spring Boot & Spring Security:** * **Auth Service:** Procesa credenciales y genera tokens **JWT**.
    * **Alumnos Service:** Gestiona la lógica académica y la generación de reportes PDF.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 3. Persistencia Políglota (Bases de Datos Externas)

Hemos sustituido la base de datos temporal H2 por un sistema de **persistencia real y externa**. Los datos ya no se borran al reiniciar el servidor gracias al uso de **Volúmenes de Docker**.

|  Componente |  Tecnología |  Rol |
| :--- | :--- | :--- |
| **BD Seguridad** | **MariaDB** | Almacena usuarios, roles y permisos de acceso. |
| **BD Negocio** | **MySQL 8.0** | Almacena la información de alumnos, idiomas y registros académicos. |

### ¿Cómo se conectan?
La comunicación se realiza mediante una **Red Virtual de Docker**. Los microservicios utilizan conectores JDBC para hablar con sus respectivas bases de datos, utilizando variables de entorno para una configuración segura y flexible (Perfiles `dev` y `prod`).

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 4. Flujo de una solicitud (Ejemplo: Ver Alumnos)



1. **Usuario:** Solicita la lista de alumnos al Gateway (Puerto 8080).
2. **Gateway:** Identifica que la ruta pertenece a `alumnos-service` y le redirige la petición.
3. **Security:** Se valida el token **JWT** enviado por el usuario.
4. **Servicio:** El microservicio de Alumnos consulta a la base de datos **MySQL**.
5. **Respuesta:** Los datos viajan de vuelta al usuario a través del Gateway.

