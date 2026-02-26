# 🗄️ Persistencia de Datos: H2 y Spring Data JPA

  <img src="https://img.shields.io/badge/Database-H2_Embedded-005f00?style=for-the-badge&logo=databricks" />
  <img src="https://img.shields.io/badge/ORM-Hibernate_JPA-blue?style=for-the-badge&logo=hibernate" />

<br>

El sistema de persistencia de **Enlace Pro** está diseñado para ser ligero, eficiente y fácil de desplegar. Utilizamos un enfoque de base de datos embebida que permite que la aplicación sea totalmente autocontenida, facilitando su uso en entornos educativos sin necesidad de configuraciones complejas de servidores externos.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. Tecnología y Contexto Técnico

Hemos seleccionado un stack tecnológico que prioriza la velocidad de desarrollo y la integridad referencial de la información académica.

| **Aspecto** | **Descripción** |
| :--- | :--- |
| **Motor de BD** | **H2 Database** (Modo Embebido). Una solución **en memoria** que permite arranques instantáneos y un entorno de desarrollo limpio y autocontenido. |
| **Persistencia** | **Spring Data JPA**. Actúa como la capa de abstracción que mapea nuestras clases Java directamente a tablas SQL, simplificando las operaciones CRUD. |
| **Objetivo** | Garantizar un modelo relacional estricto entre los alumnos (`ALUMNOS`) y su diversidad lingüística (`IDIOMAS`). |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. Modelo Entidad-Relación (ER)

El corazón de nuestra base de datos se basa en una relación clara que refleja la realidad de las Aulas de Enlace.



Se establece una relación **One to Many (1:N)**:
* Un **Idioma** puede ser la lengua nativa de muchos **Alumnos**.
* Cada **Alumno** está vinculado estrictamente a un único **Idioma Nativo** para personalizar su interfaz.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 3. Esquema de Tablas (Mapeo JPA)

La arquitectura de tablas se genera automáticamente gracias a Hibernate, asegurando que el esquema SQL coincida siempre con nuestro código Java.

### 3.1. Tabla: `ALUMNOS`
| **Campo** | **Tipo SQL** | **Restricción** | **Mapeo JPA** |
| :--- | :--- | :--- | :--- |
| `id` | `BIGINT` | **PK**, Auto Inc. | `@Id`, `@GeneratedValue` |
| `nombre` | `VARCHAR` | NOT NULL | Propiedad simple |
| `email` | `VARCHAR` | NOT NULL, **UNIQUE** | `@Column(unique = true)` |
| `idioma_id` | `BIGINT` | **FK** -> `IDIOMAS` | `@ManyToOne` |

### 3.2. Tabla: `IDIOMAS`
| **Campo** | **Tipo SQL** | **Restricción** | **Mapeo JPA** |
| :--- | :--- | :--- | :--- |
| `id` | `BIGINT` | **PK**, Auto Inc. | `@Id` |
| `nombre_idioma`| `VARCHAR` | NOT NULL, UNIQUE | Propiedad simple |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 4. Gestión del Ciclo de Datos

El uso de H2 y JPA en Enlace Pro se divide en **tres fases operativas** que optimizan el rendimiento:

### Fase A: Inicialización en Memoria
Al arrancar la aplicación, Spring Boot levanta el motor H2. Gracias a la configuración de JPA, las tablas se crean en milisegundos. Esto permite que el sistema esté listo para recibir alumnos e idiomas sin esperas de conexión a red.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase B: Operaciones Atómicas
Cada vez que un profesor guarda un informe o registra a un alumno, JPA gestiona la transacción. Si algo falla (por ejemplo, un email duplicado), el sistema realiza un *rollback* automático, protegiendo la integridad de la base de datos de errores accidentales.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase C: Entorno de Pruebas (Testing)
Para el equipo de desarrollo, H2 es la herramienta perfecta de **Testing**. Nos permite ejecutar pruebas unitarias con datos ficticios que se destruyen al finalizar la prueba, asegurando que cada test comience desde un estado "limpio" y sin interferencias.



  <br>
  <img src="https://img.shields.io/badge/Integridad-Referencial_Activa-success?style=flat-square" />
  <img src="https://img.shields.io/badge/Modo-Embedded_H2-orange?style=flat-square" />