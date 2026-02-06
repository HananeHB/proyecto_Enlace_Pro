## Estructura Interna por Componentes de "Enlace Pro"

La aplicación está **modularizada** en dos grandes módulos principales: `alumnos` y `common`.

### 1. Módulos Principales

|**Módulo**|**Contenido Principal**|
|---|---|
|**`alumnos`**|Lógica específica para la **gestión de estudiantes**.|
|**`common`**|**Utilidades, modelos** y lógica transversal que puede ser usada por otros módulos.|

- **Relación de Uso:** El módulo `alumnos` **utiliza** el módulo `common`.
    

### 2. Estructura por Capas (Arquitectura Limpia/Dominio)

Ambos módulos (`alumnos` y `common`) siguen una estructura por capas, separando las responsabilidades de forma clara: **Infraestructura, Aplicación y Dominio**.

|**Capa (Package)**|**Responsabilidad Principal**|**Dependencias**|
|---|---|---|
|**`domain`**|Contiene las **reglas de negocio centrales**, modelos de datos (entidades) y las interfaces del repositorio (lo que debe hacer el almacenamiento de datos).|**Es el núcleo y no debe depender de otras capas.**|
|**`application`**|Contiene la lógica para la **orquestación y los casos de uso** (`usecase`, `service`, `command`), implementando las reglas del dominio.|Depende de `domain`.|
|**`infrastructure`**|Contiene los **detalles técnicos** y adaptadores externos (Web REST, Base de Datos JPA, Mappers, etc.). Es la capa más externa.|Depende de `application` y `domain`.|

> **Flujo de Dependencia:** Infraestructura $\rightarrow$ Aplicación $\rightarrow$ Dominio.

---

### 3. Detalle de Componentes del Módulo `alumnos`

La capa de `infrastructure` es la más compleja por contener todos los adaptadores técnicos.

| **Capa**             | **Componentes Clave**                                                              | **Propósito**                                                                                                             |
| -------------------- | ---------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| **`domain`**         | `error`, `model`, `repository`                                                     | Definición de **modelos de negocio** (`Alumno`, `Idioma`) e **interfaces** de repositorio.                                |
| **`application`**    | `service`, `command`, `usecase`                                                    | Implementación de las **operaciones de negocio** (ej. "Crear Alumno").                                                    |
| **`infrastructure`** | `web` (`rest`, `dto`, `validator`), `db` (`jpa`, `repository`), `config`, `mapper` | **Adaptadores web** (controladores REST), **persistencia** (implementación JPA), configuración y transformación de datos. |

---
### 4. Interfaz de Repositorios (Inversión de Dependencia)

Este nivel destaca cómo la capa de **Infraestructura implementa las Interfaces definidas en el Dominio**, aplicando el principio de Inversión de Dependencia.

- El módulo **`common/domain`** define **interfaces genéricas** (`CRUDRepository`) y modelos base (`Identificador`).
    
- El módulo **`alumnos/domain`** define **interfaces específicas** (`AlumnoRepository`, `IdiomaRepository`), que heredan de las genéricas.
    

#### Implementación Real en Infraestructura

El módulo `alumnos/infrastructure/db/jpa` contiene las implementaciones reales:

- **`AlumnoJpaRepositoryImpl`** e **`IdiomaJpaRepositoryImpl`** **implementan** las interfaces del dominio (`AlumnoRepository` e `IdiomaRepository`).
    
- Estas implementaciones utilizan clases específicas de la tecnología (ej. `AlumnoEntityJpaRepository` de Spring Data JPA) para interactuar con la Base de Datos.
    

Esta clara separación asegura que la **lógica de negocio (`domain`) no sabe _cómo_ se guardan los datos**, sino solo **qué se puede hacer con ellos** (definido en las interfaces del repositorio).