#  Documentación Técnica: Swagger & OpenAPI

<img src="https://img.shields.io/badge/OpenAPI-3.0-green?style=for-the-badge&logo=openapiinitiative" />
  <img src="https://img.shields.io/badge/Swagger-UI-brightgreen?style=for-the-badge&logo=swagger" />


Para facilitar el consumo de los microservicios y asegurar que la comunicación entre el Frontend y el Backend sea fluida, hemos implementado **Swagger UI** bajo la especificación **OpenAPI**.



<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  1. Acceso a la Documentación
Cada microservicio es capaz de auto-documentarse. Puedes acceder a las interfaces interactivas en las siguientes direcciones (en entorno local):

| 🌐 Servicio | 🔗 Enlace Local |
| :--- | :--- |
| **Auth Service** | `http://localhost:8081/swagger-ui.html` |
| **Alumnos Service** | `http://localhost:8082/swagger-ui.html` |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  2. Capacidades de la Interfaz
A través de Swagger, el equipo de desarrollo y los evaluadores pueden:

1. **Visualizar los Endpoints**: Lista completa de todas las rutas disponibles (GET, POST, PUT, DELETE).
2. **Modelos de Datos**: Descripción detallada de los objetos de entrada y salida (DTOs), incluyendo tipos de datos y validaciones.
3. **Probar peticiones (Try it out)**: Realizar llamadas reales a la API directamente desde el navegador.
4. **Seguridad**: Se ha integrado un botón de **Authorize** para pegar el token **JWT** y probar las rutas protegidas.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  3. Configuración en el Código
La documentación se genera dinámicamente utilizando la dependencia `springdoc-openapi-starter-webmvc-ui`. Se han utilizado anotaciones estratégicas para enriquecer la descripción:

* **`@Operation`**: Define el propósito de cada método y su impacto en el negocio.
* **`@Schema`**: Detalla las propiedades de las entidades, tipos de datos y restricciones.
* **`@ApiResponse`**: Documenta los códigos de estado HTTP (**200 OK**, **401 Unauthorized**, **404 Not Found**, etc.).

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### 🛡️ Nota sobre Seguridad en Desarrollo
> Aunque los microservicios están protegidos, la configuración de **Security** permite el acceso libre a estas rutas de documentación para facilitar la fase de integración y auditoría técnica sin bloqueos.

