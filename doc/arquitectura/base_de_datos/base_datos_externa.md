# 🗄️ Persistencia: Migración a Bases de Datos Externas

![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) ![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)

Una de las evoluciones más críticas en **Enlace Pro** ha sido la transición de un almacenamiento volátil en memoria (H2) hacia un sistema de **persistencia real y profesional** utilizando motores de bases de datos externos.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. El fin de H2: ¿Por qué migrar?

En las primeras fases del proyecto, se utilizó **H2 Database** por su facilidad de configuración. Sin embargo, presentaba limitaciones inaceptables para una aplicación de producción:
* **Volatilidad**: Los datos se borraban cada vez que el microservicio se reiniciaba.
* **Falta de concurrencia**: No estaba optimizada para múltiples conexiones simultáneas.
* **Dificultad de inspección**: Era complejo consultar los datos desde herramientas externas.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. Estrategia de Persistencia Políglota

En nuestra arquitectura de microservicios, hemos aplicado el principio de **Database-per-Service**. Esto significa que cada microservicio es dueño de su propio esquema y motor de base de datos, evitando que dependan entre sí a nivel de datos.

| Microservicio | Motor de BD | Justificación |
| :--- | :--- | :--- |
| **Auth-Service** | **MariaDB** | Motor robusto y ligero, ideal para la gestión de usuarios y tablas de seguridad. |
| **Alumnos-Service** | **MySQL 8.0** | Estándar de la industria para datos relacionales complejos (Alumnos, Idiomas, Registros). |



<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 3. Implementación con Docker y Volúmenes

Para garantizar que los datos persistan incluso si los contenedores de Docker se eliminan, hemos implementado **Volúmenes de Docker**:

* **Mapeo de datos**: Los datos que MySQL y MariaDB generan dentro del contenedor se sincronizan en una carpeta física del servidor/PC (`/var/lib/mysql`).
* **Independencia**: Podemos actualizar la versión del motor de la base de datos sin riesgo de perder la información de los alumnos.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 4. Conectividad y Acceso

La conexión entre Spring Boot y las bases de datos se realiza mediante **JDBC** y **Spring Data JPA**, configurando los parámetros en los archivos de propiedades:

```properties
# Ejemplo de configuración para Alumnos (MySQL)
spring.datasource.url=jdbc:mysql://db-alumnos:3306/alumnos_db
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
```

Gestión Visual: Adminer
Para facilitar la administración durante el desarrollo y la evaluación, hemos incluido un contenedor con Adminer. Es una interfaz web ligera que nos permite ejecutar consultas SQL y revisar las tablas de ambos motores (MySQL y MariaDB) desde un único lugar.

## 5. Beneficios de la nueva arquitectura de datos
Seguridad: Los datos están protegidos y aislados.

Escalabilidad: Cada base de datos puede configurarse y optimizarse de forma independiente según su carga.

Integridad: MySQL y MariaDB garantizan que las relaciones entre alumnos e idiomas se mantengan consistentes (Foreign Keys).

