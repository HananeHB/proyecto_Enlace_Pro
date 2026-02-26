# 🌐 Documentación de la API: Módulo Traducciones

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Idiomas-Multilingüe-E91E63?style=for-the-badge" />

<br>

El endpoint de **Traducciones** es el núcleo de la internacionalización en Enlace Pro. Su función es actuar como puente entre los contenidos educativos (textos y vocabulario) y sus equivalentes en diferentes idiomas. Este módulo permite que la aplicación sea verdaderamente inclusiva, proporcionando las traducciones necesarias para que alumnos y familias puedan entender el material en su lengua materna.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. Especificaciones Técnicas del Endpoint

Debido a su naturaleza relacional, este endpoint maneja múltiples claves externas para vincular cada traducción con su texto, vocabulario e idioma correspondiente.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :--- | :--- | :---: | :--- | :--- |
| `/traducciones` | **GET** | N/A | `200` | Lista de todas las traducciones | `TraduccionNotFound` |
| `/traducciones` | **POST** | `{"traduccion":"...", "id_idioma":2}` | `201` | Registro de traducción creado | `400: Bad Request` |
| `/traducciones/{id}` | **GET** | N/A | `200` | Detalle de traducción única | `404: Not Found` |
| `/traducciones/{id}` | **PUT** | `{"traduccion":"...", "id_texto":1}` | `200` | Traducción actualizada | `400, 404` |
| `/traducciones/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. Lógica de Interconexión Lingüística

La gestión de traducciones en Enlace Pro se organiza en **tres fases relacionales** para asegurar que el contenido multilingüe sea coherente.



### Fase A: Mapeo de Identificadores
Al crear una nueva traducción mediante **POST**, el sistema no solo guarda la palabra o frase traducida. El servidor valida que el `id_idioma`, el `id_texto` y el `id_vocabulario` existan previamente. Esto garantiza que una traducción como *"Apple"* esté correctamente vinculada a la palabra *"Manzana"* y al idioma *"Inglés"*.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase B: Recuperación de Contexto
Cuando un usuario cambia el idioma en la interfaz "Liquid Glass", el frontend utiliza las peticiones **GET** para buscar las traducciones correspondientes. El sistema devuelve un objeto JSON complejo que incluye todas las referencias, permitiendo que la aplicación muestre el informe de progreso o el material educativo en el idioma seleccionado instantáneamente.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase C: Integración con Informes
Una característica clave es la vinculación con el `id_informe`. Esto permite que las evaluaciones generadas por los profesores puedan ser traducidas de forma estructurada, facilitando que la información académica llegue a las familias en un formato que puedan comprender perfectamente.

---

  <br>
  <img src="https://img.shields.io/badge/Relaciones-Many--to--One-blue?style=flat-square" />
  <img src="https://img.shields.io/badge/Integridad-Referencial-success?style=flat-square" />