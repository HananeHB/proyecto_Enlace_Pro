# 🏗️ Arquitectura del Sistema: El Modelo C4

  <img src="https://img.shields.io/badge/Architecture-C4_Model-005f00?style=for-the-badge&logo=architecture" />
  <img src="https://img.shields.io/badge/Backend-Spring_Boot-green?style=for-the-badge&logo=springboot" />

<br>

Para garantizar que **EnlacePro** sea una plataforma escalable y fácil de mantener, hemos seguido el estándar del **Modelo C4**. Este enfoque nos permite visualizar la arquitectura desde una perspectiva global (Contexto) hasta una técnica (Contenedores), facilitando la comprensión de cómo fluye la información entre el usuario y la base de datos.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## Nivel 1: Diagrama de Contexto

En este nivel, tratamos a EnlacePro como una "caja negra". El foco principal son las personas que utilizan el sistema y las entidades externas con las que interactúa.

### 👥 Actores y Sistemas

| Elemento | Tipo |  Función Principal |  Interacción |
| :--- | :--- | :--- | :--- |
| **Administrador** | Persona | Gestión de usuarios, roles e idiomas. | Escritura y Gestión total. |
| **Usuario** | Persona | Consulta de contenidos, niveles y reportes. | Lectura y Gestión operativa. |
| **Enlace Pro** | Sistema | Aplicación central de lógica de negocio. | Centro del ecosistema. |
| **Base de Datos** | Externo | Persistencia de información en tiempo real. | Lectura/Escritura (H2). |



<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## Nivel 2: Diagrama de Contenedores

Este nivel detalla la distribución técnica de la solución. Aquí es donde separamos la interfaz de usuario (Frontend) de la lógica de procesamiento (Backend) y el almacenamiento.

### Estructura de Contenedores

* **Aplicación Web (Cliente)**: Desarrollada con **Spring Boot + Thymeleaf**. Es la encargada de renderizar las vistas "Liquid Glass" y gestionar la navegación del usuario mediante el navegador.
* **Servicios REST (Servidor)**: El núcleo lógico del sistema. Este contenedor procesa las peticiones, aplica las reglas de negocio y asegura que solo los usuarios autorizados accedan a los datos.
* **Base de Datos (H2)**: Motor de persistencia relacional en memoria que garantiza una respuesta ultrarrápida para la gestión de alumnos, contenidos y niveles.



<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 3. Flujo de Comunicación Técnica

La arquitectura de contenedores de Enlace Pro funciona bajo un flujo de **tres pasos sincronizados**:

### Fase A: Interacción del Usuario
El Administrador o el Usuario inician una acción desde su navegador. La **Aplicación Web** recibe esta interacción y, en lugar de procesar los datos directamente, prepara una solicitud formal hacia el servidor.

---

### Fase B: Procesamiento Lógico
Los **Servicios REST** reciben la petición. Aquí es donde Spring Boot toma el control: valida la seguridad, comprueba que el ID del alumno o idioma sea correcto y ejecuta la lógica necesaria (como el cálculo de niveles o la preparación de una traducción).

---

### Fase C: Persistencia y Respuesta
Finalmente, el servicio se comunica con la **Base de Datos**. Una vez recuperada o guardada la información, el servidor devuelve un JSON a la Aplicación Web, la cual actualiza la interfaz del usuario de forma fluida y sin recargas innecesarias.

---

  <br>
  <img src="https://img.shields.io/badge/Client-Thymeleaf-005f00?style=flat-square" />
  <img src="https://img.shields.io/badge/Server-REST_API-blue?style=flat-square" />
  <img src="https://img.shields.io/badge/DB-H2_In_Memory-orange?style=flat-square" />