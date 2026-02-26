# 📄 Generación de Reportes: Exportación a PDF

  <img src="https://img.shields.io/badge/Formato-Documentos_PDF-red?style=for-the-badge&logo=adobe-acrobat-reader" />
  <img src="https://img.shields.io/badge/Librería-Flying_Saucer-blueviolet?style=for-the-badge" />

<br>

Una funcionalidad crítica para el equipo directivo de las Aulas de Enlace es la capacidad de generar documentos oficiales de forma automatizada. Enlace Pro permite transformar la información digital del sistema en archivos PDF profesionales, facilitando la entrega de informes, fichas de seguimiento y listados administrativos sin errores manuales.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. Tipos de Documentos Generados

El sistema permite exportar diferentes tipos de reportes según la necesidad del docente o del centro educativo:

| 📝 Tipo de Reporte | 📋 Contenido Incluido | ✨ Utilidad |
| :--- | :--- | :--- |
| **Ficha de Alumnado** | Datos personales, lenguaje materno y día de matriculación. | Expediente oficial y reuniones con familias. |
| **Ficha de Idiomas** | Nombres de idiomas y día que se agregaron. | Control de los idiomas y organización. |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. Funcionamiento del Motor de Exportación

La creación de estos documentos se realiza en **tres pasos técnicos** que aseguran que el diseño de la web se traslade perfectamente al papel.



### Fase A: Renderizado de la Plantilla
En primer lugar, el sistema toma una plantilla de Thymeleaf diseñada específicamente para impresión. Spring Boot inyecta los datos del alumno o de la clase en el HTML, generando una vista "invisible" que contiene toda la información necesaria ya formateada.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase B: Conversión a Documento (Flying Saucer)
Para transformar el HTML en un archivo real, utilizamos la combinación de **Flying Saucer** e **iText**. Este motor interpreta el código y los estilos CSS, dibujando cada elemento, tabla y texto en una estructura de documento PDF. Esto nos permite mantener la misma estética limpia que vemos en la aplicación web.

> 🛠️ **Nota Técnica:** El proceso está optimizado para que los documentos pesen poco pero mantengan una alta calidad de impresión, cumpliendo con los estándares necesarios para la documentación oficial de los institutos.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


### Fase C: Descarga y Flujo de Datos
Una vez generado el PDF, el servidor no guarda el archivo (ahorrando espacio en disco), sino que lo envía directamente al navegador del profesor como un **flujo de datos (Stream)**. El navegador recibe el archivo al instante, permitiendo que el equipo directivo lo abra, lo guarde o lo imprima directamente.

---

  <br>
  <img src="https://img.shields.io/badge/Motor-iText_PDF-black?style=flat-square" />
  <img src="https://img.shields.io/badge/Tecnología-Spring_Streaming_Resource-green?style=flat-square&logo=springboot" />