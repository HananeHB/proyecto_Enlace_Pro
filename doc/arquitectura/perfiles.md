#  Gestión de Perfiles y Configuración por Entornos

<img src="https://img.shields.io/badge/Spring_Boot-Profiles-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
  <img src="https://img.shields.io/badge/Strategy-Externalized_Config-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Security-Environment_Variables-orange?style=for-the-badge" />
  

En **Enlace Pro**, hemos implementado una estrategia de **Externalized Configuration** mediante el uso de perfiles de Spring (`Profiles`). Esto nos permite separar la configuración de desarrollo de la configuración de producción sin necesidad de modificar el código fuente.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>

## 1. ¿Qué son los Perfiles de Spring?

Los perfiles nos permiten "etiquetar" partes de la configuración de la aplicación para que solo se activen en momentos específicos. Hemos definido dos entornos principales:

### 🟢 Perfil: `dev` (Desarrollo)
Se utiliza cuando trabajamos localmente desde el IDE (IntelliJ/Eclipse).
* **Base de Datos:** Puede apuntar a `localhost` o incluso a una base de datos embebida para pruebas rápidas.
* **Logs:** Nivel `DEBUG` para ver todo lo que ocurre en la consola.
* **Seguridad:** Configuraciones más permisivas para facilitar el testeo.

### 🔵 Perfil: `prod` (Producción / Docker)
Es el perfil que se activa automáticamente dentro de los contenedores de Docker.
* **Base de Datos:** Apunta a los nombres de servicio de Docker (`db-alumnos`, `db-auth`).
* **Logs:** Nivel `INFO` o `WARN` para no saturar el almacenamiento del servidor.
* **Seguridad:** Configuración estricta de CORS y tokens JWT.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>

## 2. Estructura de Archivos

La configuración se divide en archivos específicos dentro de `src/main/resources`:

| Archivo | Propósito |
| :--- | :--- |
| `application.yml` | Configuración base común a todos los entornos. |
| `application-dev.yml` | Especificaciones para el trabajo local. |
| `application-prod.yml` | Especificaciones críticas para el despliegue en contenedores. |



<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>

## 3. Inyección de Variables mediante Docker (.env)

Para evitar subir contraseñas o datos sensibles al repositorio de GitHub, el perfil de producción (`prod`) utiliza **variables de entorno**. Estas variables se definen en un archivo externo `.env` y se inyectan a través del `docker-compose.yml`:

```yaml
# Fragmento del docker-compose.yml
environment:
  - SPRING_PROFILES_ACTIVE=prod
  - DB_PASSWORD=${DB_PASSWORD} # Inyección desde .env
  - AUTH_SERVICE_URL=${AUTH_SERVICE_URL}
```

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>

## 4. Ventajas de este Enfoque

<div style="background-color: #22351f; border-left: 5px solid #28a745; padding: 15px; border-radius: 5px;">
  <strong>✅ Seguridad</strong>
  <p>Las credenciales de la base de datos no están escritas en el código (están en el archivo .env local de cada administrador, fuera del control de versiones).</p>
</div>
<div style="background-color: #343a34; border-left: 5px solid #28a745; padding: 15px; border-radius: 5px; margin-top: 20px;" >
  <strong>✅ Flexibilidad</strong>
  <p>Podemos cambiar la URL del API Gateway o los puertos de los microservicios simplemente editando el archivo .env y reiniciando los contenedores, sin recompilar.</p>
</div>
<div style="background-color: #22351f; border-left: 5px solid #28a745; padding: 15px; border-radius: 5px; margin-top: 20px;">
  <strong>✅ Consistencia</strong>
  <p>El mismo archivo .jar que compilamos en local es el que corre en producción; solo cambia su comportamiento dinámicamente según el perfil activo.
</p>
</div>

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>

## 5. Cómo activar un Perfil

* **En el IDE:** Añadiendo `-Dspring.profiles.active=dev` en las opciones de ejecución de la JVM (VM Options).
* **En Docker:** Mediante la variable de entorno `SPRING_PROFILES_ACTIVE=prod` definida en el archivo de orquestación `docker-compose.yml`.

