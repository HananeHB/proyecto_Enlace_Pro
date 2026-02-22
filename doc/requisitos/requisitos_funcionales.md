#  Requisitos Funcionales (RF)

> **Ecosistema de Usuarios:** 🎓 **Alumno** | 👨‍🏫 **Profesor** | 🏠 **Padre/Tutor** | 🔑 **Director**

---

|  ID |  Requisito Funcional |  Actores |  Descripción |
| :---: | :--- | :--- | :--- |
| **F1** | **Autenticación de Usuarios** | Todos los roles | El sistema debe permitir el inicio de sesión seguro para cada tipo de perfil. |
| **F2** | **Selección de Idioma** | 🎓 🏠 | Opción de elegir el idioma materno al iniciar sesión para personalizar la experiencia. |
| **F3** | **Traducción de Contenido** | 🎓 🏠 | Visualización de contenido pedagógico y comunicados con traducción accesible en el idioma seleccionado. |
| **F4** | **Asignación de Nivel** | 👨‍🏫 | Evaluación bimestral y asignación de nivel (**Bajo / Medio / Alto**) según el progreso del alumno. |
| **F5** | **Filtrado Dinámico** | 🎓 | El sistema solo muestra el material adaptado al nivel del alumno, apoyado por imágenes didácticas. |
| **F6** | **Carga Multinivel** | 👨‍🏫 | Interfaz para subir el contenido original junto a sus tres variantes adaptadas. |
| **F7** | **Panel de Gestión (CRUD)** | 🔑 | Control total para añadir, eliminar o modificar alumnos, padres, profesores e idiomas. |

---

### 🛡️ Notas Técnicas
* **Seguridad:** Los requisitos **F1** y **F7** se gestionan mediante roles de autoridad en Spring Security.
* **Frecuencia:** Según **F4**, el sistema debe permitir la actualización de niveles cada 60 días para reflejar la evolución real.
* **Accesibilidad:** **F5** prioriza el uso de material visual para reforzar la inmersión lingüística.

---

👉 **Siguiente paso:** Consulta nuestra sección Requisitos no Funcionales

[![Requisitos no Funcionales](https://img.shields.io/badge/VER_REQUISITOS_NO_FUNCIONALES-blue?style=for-the-badge&logo=rocket)](requisitos_no_funcionales.md)
