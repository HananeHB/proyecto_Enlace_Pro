# 🌐 Documentación de la API: Módulo Idiomas

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Gestión-Multilingüe-E91E63?style=for-the-badge" />

<br>

El endpoint de **Idiomas** es el motor que permite la expansión de EnlacePro. Define las lenguas disponibles en el sistema, sirviendo como catálogo de referencia para el módulo de traducciones y la configuración de perfil de los alumnos. Gracias a esta gestión centralizada, el administrador puede añadir nuevos idiomas al sistema de forma dinámica conforme el aula recibe estudiantes de diferentes partes del mundo.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. Especificaciones Técnicas del Endpoint

A continuación se detallan las operaciones para administrar el catálogo de idiomas soportados por la plataforma.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/idiomas` | **GET** | N/A | `200` | Listado de idiomas disponibles | `IdiomaNotFound` |
| `/idiomas` | **POST** | `{"nombre":"..."}` | `201` | Registro de nuevo idioma creado | `400: Bad Request` |
| `/idiomas/{id}` | **GET** | N/A | `200` | Detalle de idioma único | `404: Not Found` |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. Gestión de la Diversidad Lingüística

La administración de idiomas se organiza en **las siguientes fases clave** que aseguran la correcta integración de nuevas lenguas en el sistema.



### Fase A: Registro de Nuevas Lenguas
Mediante la petición **POST**, el administrador puede dar de alta un nuevo idioma (por ejemplo, "Japonés"). El sistema genera un identificador único que servirá como clave externa para todas las futuras traducciones de vocabulario, textos e informes, permitiendo que la app crezca sin necesidad de reprogramar el código base.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase B: Identificación y Mapeo
El método **GET** permite al sistema cargar los selectores de idioma que vemos en la interfaz. Cuando un alumno se registra, su perfil queda vinculado a uno de estos `id_idioma`. Esto es lo que permite que, al iniciar sesión, la arquitectura de **Enlace Pro** sepa exactamente qué tabla de traducciones debe consultar para personalizar la experiencia.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase C: Integración con el Ecosistema i18n
Cada idioma registrado en este módulo actúa como un "ancla" para el resto de la base de datos. Sin un idioma registrado aquí, no se pueden crear traducciones ni informes localizados. Esto asegura que toda la información académica sea coherente y que no existan datos huérfanos sin una referencia lingüística clara.

---

  <br>
  <img src="https://img.shields.io/badge/Estándar-ISO_Languages-orange?style=flat-square" />
  <img src="https://img.shields.io/badge/Escalabilidad-Ilimitada-success?style=flat-square" />