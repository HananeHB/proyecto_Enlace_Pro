# <img src="img/doc/logo.png" width="45"> ENLACE PRO
> **Plataforma de adaptación lingüística para Aulas de Enlace (Secundaria).**

![Version](https://img.shields.io/badge/version-2.0.0-blue.svg?style=for-the-badge)
![Status](https://img.shields.io/badge/status-en_desarrollo-green.svg?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white) 
![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) 



![Portada Enlace Pro](img/doc/Portadaa.png)


---


## 📝 Introducción
**Enlace Pro** es una plicación diseñada para facilitar el trabajo del profesorado y el aprendizaje del alumnado en las **Aulas de Enlace de Secundaria**. 

La arquitectura ha evolucionado de un monolito modular a un sistema de Microservicios desarrollado en ![Java](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring&logoColor=white)

Aplicando:
* **Backend:** Construido con **Spring Boot**.
* **Arquitectura:** Implementación de **Patrón Hexagonal** (Puertos y Adaptadores).
* **Metodología:** Desarrollo mediante **Vertical Slicing**, garantizando funcionalidades completas e independientes.

---

## 👥 Equipo del Proyecto

<table style="border: none;">
  <tr>
    <td align="center" width="200">
      <a href="https://github.com/HananeHB">
            <img src="https://avatars.githubusercontent.com/u/158471499?v=4" width="100" style="border-radius: 50%;" />
        </a><br>
      <b>Hanane </b><br>
      <sub>HananeHB</sub>
    </td>
    <td align="center" width="200">
        <a href="https://github.com/JennyCS48">
            <img src="https://avatars.githubusercontent.com/u/195781876?v=4" width="100" style="border-radius: 50%;" />
        </a>
        <br>
        <b>Jennifer</b><br>
        <sub>JennyCS48</sub>
    </td>
    <td align="center" width="200">
     <a href="https://github.com/nuasai04">
            <img src="https://avatars.githubusercontent.com/u/194843002?v=4" width="100" style="border-radius: 50%;" />
        </a><br>
      <b>Nuhaila</b><br>
      <sub>nuasai04</sub>
    </td>
    
  </tr>
</table>

**Última actualización:** Febrero 2026 

<a href="/doc/versiones.md">
    <img src="https://img.shields.io/badge/Historial_Versiones-24292e?style=for-the-badge&logo=github&logoColor=white" />
</a>

---

## 🗺️ Índice de Documentación
> Toda la documentación está organizada por ficheros aparte para facilitar su consulta.

### 1. Contexto y Requisitos Funcionales
| Sección | Contenido |
| :--- | :--- |
| **Contexto de la aplicación** | [Mundo real del problema](/doc/contexto/problema_real.md) • [Qué apps existen](/doc/contexto/apps_existentes.md) • [Cómo la mía es mucho mejor porque hace...](/doc/contexto/propuesta_valor.md) |
| **Funcionalidad** | [Casos de Uso (Actores)](/doc/requisitos/casos_de_uso.md) |
| **Especificaciones** | [Requisitos Funcionales](/doc/requisitos/requisitos_funcionales.md) • [Requisitos No Funcionales](/doc/requisitos/requisitos_no_funcionales.md) |
| **Seguridad** | [Control de Acceso y Seguridad](/doc/seguridad_control_de_acceso.md) |

### 2. Arquitectura y Datos 🏗️
Para una visión técnica profunda, consulta los diagramas y el diseño de datos:

* **Evolución:** [De monolito a microservicios](/doc/arquitectura/microservicios.md).
* **Contenedores:** [Docker](/doc/arquitectura/docker.md).
* **Persistencia:** [Migración a BBDD externa](/doc/arquitectura/base_de_datos/base_datos_externa.md) • [Esquema de Base de Datos](/doc/arquitectura/base_de_datos/base_de_datos.md)
* **Configuración por entornos:** [Gestión de perfiles](/doc/arquitectura/perfiles.md).
* **Modelo C4:** [Diagramas de Contexto y Contenedores](/doc/arquitectura/modelo_c4.md).
* **Infraestructura:** [Plan de Despliegue](/doc/arquitectura/despliegue.md) •  [Componentes del sistema](/doc/arquitectura/componentes.md).
* **API:** [Diseño de Servicios REST](/doc/arquitectura/servicios_rest/rest.md).


### 3. Seguridad y API

* **Autenticación y Autorización:** [Spring Security + JWT](/doc/seguridad/auth.md).
* **Documentación Técnica:** [Swagger & OpenAPI](/doc/documentacion_api/swagger.md).


### 4. Frontend Y Experiencia de Usuario

* **Motor de vistas:** [Thymeleaf y fragmentos](/doc/front/thymeleaf.md).
* **Diseño Visual:** [Tailwind CSS](/doc/front/tailwind.md).
* **Adaptación lingüística:** [Internacionalización (i18n)](/doc/front/i18n.md).
* **Generación de Reportes:** [Exportación dinámica a PDF](/doc/front/pdf.md).


### 5. Referencias y Apoyo 📚
* 📖 [Manual de Usuario](/doc/referencias/manual_usuario/manual_usuario.md)
* 🏁 [Conclusiones Individuales](/doc/referencias/conclusiones.md)
* 🖇️ [Bibliografía](/doc/referencias/bibliografia.md)
* 🔗 [Anexos](/doc/referencias/anexos/anexos.md)


---


## 🛠️ Tecnologías Utilizadas
| Categoría | Herramientas |
| :--- | :--- |
| **Lenguaje** | ![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)|
| **Framework** | ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)  |
| **Arquitectura** | ![Microservices](https://img.shields.io/badge/Microservices-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white)|
| **Gestión de dependencias** | ![Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) !|
| **Seguridad** |![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)  ![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)|
| **Base de Datos** | ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) ![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=white)|
| **Persistencia** | ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white) |
| **Documentación** |![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)|
| **Contenedorización** |![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)  |
| **Motor de Vistas** | ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C00.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white) |
| **Estilos** | ![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css&logoColor=white) |
| **Internacionalización** | ![i18n](https://img.shields.io/badge/i18n-🌐-blue?style=for-the-badge) |

---

## Resumen visual


```mermaid

mindmap
  root((EnlacePro))
    Arquitectura
      Microservicios
      Docker
      API Gateway
    Negocio
      Gestión Alumnos
      Idiomas
      Reportes PDF
    Seguridad
      Spring Security + JWT
```




<img src="https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png" width="100%">


<p align="center" style="margin-top:40px;">
  <img src="img/doc/logo.png" alt="Visitas" style="width: 45px;"/><br>
  <sub><b>Enlace Pro 2026</b> •Desarrollado con ❤️ para la educación secundaria.</sub><br>
  
</p>