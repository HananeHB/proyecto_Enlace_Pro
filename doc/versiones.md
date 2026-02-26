# Registro de Control de Versiones

  <img src="https://img.shields.io/badge/Versión_Actual-2.0.0-blue?style=flat-square" />
  <img src="https://img.shields.io/badge/Deployment-Docker-blue?style=flat-square&logo=docker" />


> **Historial detallado de la evolución técnica y funcional de Enlace Pro.**



##  Versión 2.0.0 (Actual)
**Estado:** `ESTABLE` | **Fecha:** Febrero 2026

En esta versión hemos dado el salto definitivo hacia la escalabilidad, transformando la estructura base en un sistema robusto y preparado para el entorno real.

###  Mejoras y Correcciones
#### CAMBIOS DE INFRAESTRUCTURA
```diff
+ Arquitectura: Migración integral de Monolito a Microservicios.
+ Seguridad: Autenticación Stateless mediante Spring Security y JWT.
+ Datos: Persistencia real en contenedores MySQL/MariaDB con volúmenes.
+ Orquestación: Despliegue unificado mediante Docker Compose.
```

```mermaid

graph LR
    %% Definición del Monolito
    subgraph Monolito ["Monolito Modular (v 1.0.0)"]
        direction TB
        M1[ 🛡️Auth 
        Security & JWT]
        M2[🎓Alumnos 
        Business Logic]
        M3[💼 Common 
        Shared Utils]
        
        M1 --- M2
        M2 --- M3
    end

    %% Flecha de transición
    Monolito ==>|Transformación a servicios independientes| Microservicios

    %% Definición de Microservicios
    subgraph Microservicios ["Microservicios (v2.0.0)"]

        direction TB
        

        subgraph S1 [Alumnos Service]
            direction LR
            AS[Logic] --- DB1[(🛢️ MySQL )]
        end

        subgraph S2 [Auth Service]
            direction LR
            AL[Logic] --- DB2[(🛢️ MariaDB)]
        end

        subgraph S3 [Common Library]
            CL[Shared Library]
        end

        %% Dependencias de la Common Lib
        S1 -.-> S3
        S2 -.-> S3
    end
```




#### CAMBIOS DE INTERFAZ
```diff
+ UI: Rediseño modular con Tailwind CSS.
+ UX: Implementación de Temas (Dark/Light mode).
+ i18n: Adaptación lingüística dinámica para entornos educativos.
+ Reportes: Motor de exportación de listados a formato PDF.
```


<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  Versión 1.0.0
**Estado:** `FINALIZADA` | **Fecha:** Enero 2026

Salto de la fase SNAPSHOT a versión 1.0.0 tras correción integral de errores.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  Versión 0.0.1-SNAPSHOT
**Estado:** `ARCHIVADA` | **Fecha:** Diciembre 2025

#### VERSIÓN INICIAL DE PROYECTO

* **Infraestructura:** Creación del proyecto con **Spring Boot** y **Maven**.
* **Modelado:** Definición del esquema inicial de base de datos y entidades JPA.
* **Base:** Implementación de las primeras APIs de gestión 

```diff
+ Infraestructura: Creación del proyecto con Spring Boot y Maven.
+ Modelado: Definición del esquema inicial de base de datos y entidades JPA.
+ Base: Implementación de las primeras APIs de gestión 
```


## ⏳ Línea de Tiempo del Desarrollo

```mermaid
timeline
    title Evolución de Enlace Pro
    v0.0.1-SNAPSHOT : Diciembre 2025 : 🚀 Nacimiento : Prototipo inicial y modelado JPA
    v1.0.0 : Enero 2026 : 🏗️ Refactorización : Consolidación del Monolito Modular tras correción integral de errores
    v2.0.0 : Febrero 2026 : 🐳 Containerización : Migración a Microservicios y Docker
           : Seguridad : Integración de JWT Stateless 
    : Interfaz: Thymeleaf con fragmentos y Tailwind CSS
   
```




