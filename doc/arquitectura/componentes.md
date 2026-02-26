# Estructura Interna por Componentes

<img src="https://img.shields.io/badge/Arquitectura-Hexagonal-blueviolet?style=for-the-badge" />
<img src="https://img.shields.io/badge/Microservicios-Evolución-success?style=for-the-badge" />
<img src="https://img.shields.io/badge/Seguridad-JWT-red?style=for-the-badge" />

> **Análisis técnico de la arquitectura de "Enlace Pro": Modularización, Clean Architecture y Microservicios.**

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### 1. Módulos y Microservicios Principales

|  **Microservicio / Módulo** |  **Contenido Principal** |
| :--- | :--- |
| **`auth-service`** | Gestión de **seguridad, usuarios, roles** y emisión de tokens **JWT**. |
| **`alumnos-service`** | Lógica específica para la **gestión de estudiantes e idiomas**. |
| **`common`** | **Utilidades, modelos base** y excepciones transversales compartidas. |

* **Relación de Uso:** Tanto `auth-service` como `alumnos-service` **utilizan** el módulo `common` para garantizar la consistencia en modelos base y utilidades.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### 2. Estructura por Capas (Arquitectura Limpia / Hexagonal)

Cada microservicio mantiene su independencia técnica siguiendo un flujo de dependencias estricto: **Infraestructura $\rightarrow$ Aplicación $\rightarrow$ Dominio**.

|  **Capa (Package)** |  **Responsabilidad Principal** |  **Dependencias** |
| :--- | :--- | :--- |
| **`domain`** | Contiene las **reglas de negocio centrales**, entidades y las interfaces de los repositorios. Es el núcleo puro del sistema. | **Invariable.** No depende de ninguna capa externa. |
| **`application`** | Contiene los **Casos de Uso** (servicios, orquestadores). Implementa la lógica necesaria para cumplir los requisitos de negocio. | Depende únicamente de `domain`. |
| **`infrastructure`** | Contiene los **detalles técnicos y adaptadores**: Controladores REST, Seguridad (JWT), Clientes de BD y Mappers. | Capa más externa. Depende de `application` y `domain`. |



<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### 3. Detalle de Componentes por Microservicio

#### 🔐 Microservicio `auth-service` (Seguridad)
Responsable de la protección del ecosistema mediante autenticación *stateless*.

|  **Capa** |  **Componentes Clave** |  **Propósito** |
| :--- | :--- | :--- |
| **`domain`** | `User`, `Role`, `UserRepository` | Definición de identidad y reglas de acceso. |
| **`application`** | `LoginUseCase`, `JwtProvider` | Lógica de validación y generación de tokens JWT. |
| **`infrastructure`** | `SecurityConfig`, `JwtFilter`, `MariaDBAdapter` | Configuración de Spring Security y persistencia en **MariaDB**. |

#### 🎓 Microservicio `alumnos-service` (Negocio)
Responsable de la gestión académica y adaptación lingüística.

|  **Capa** |  **Componentes Clave** |  **Propósito** |
| :--- | :--- | :--- |
| **`domain`** | `Alumno`, `Idioma`, `AlumnoRepository` | Modelos de negocio y definiciones de almacenamiento. |
| **`application`** | `CreateAlumnoService`, `PdfExportService` | Orquestación de datos y generación de reportes. |
| **`infrastructure`** | `RestController`, `MySQLAdapter`, `ThymeleafVistas` | Adaptadores web, estilos con **Tailwind** y persistencia en **MySQL**. |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### 4. Inversión de Dependencia y Persistencia Políglota

Aplicamos el principio de **Inversión de Dependencia (DIP)** para desacoplar la lógica de negocio de la tecnología de almacenamiento.

* El **Dominio** define la interfaz (ej. `AlumnoRepository`).
* La **Infraestructura** implementa dicha interfaz mediante adaptadores específicos.

#### 🛠️ Configuración de Bases de Datos Híbridas
Gracias a la modularización, el sistema utiliza una estrategia de **persistencia políglota** adaptada a cada necesidad:

1. **`auth-service` $\rightarrow$ MariaDB:** Optimizado para la gestión de usuarios y roles.
2. **`alumnos-service` $\rightarrow$ MySQL 8.0:** Utilizado para la gestión masiva de datos académicos.

> **Beneficio:** Si se requiere migrar uno de los servicios a otro motor de base de datos, el impacto se limita exclusivamente a la capa de `infrastructure` del microservicio afectado.



