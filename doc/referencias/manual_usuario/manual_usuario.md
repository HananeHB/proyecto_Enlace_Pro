# 📖 Manual de Usuario: EnlacePro

<img src="https://img.shields.io/badge/Versión-2.0-blue?style=for-the-badge" />
<img src="https://img.shields.io/badge/Interfaz-Liquid_Glass-purple?style=for-the-badge" />

<br>

Bienvenido al manual visual de **EnlacePro**. Este documento detalla la navegación y funcionalidades de la interfaz.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>

> **NOTA IMPORTANTE:** La aplicación esta docketizada por lo que al abrirla en cualquier IDE se visualizará en la raíz del proyecto un documento "docker-compose.yml" indicando que puede hacerse un ***docker copose up*** para arrancar el contenedor de la parte de Backend de la aplicación.

```Plaintext
┌──────────────────────────────────────────────────────────┐
│  $ docker-compose up                                     │
│                                                          │
│  [+] up 5/5                                              │
│  ✔ Network proyecto_enlace_pro_default       Created    |  
│  ✔ Volume proyecto_enlace_pro_mysql_data     Created    |
│  ✔ Container enlacepro-mysq                  Created    |
│  ✔ Container proyecto_enlace_pro-adminer-1   Created    |
│  ✔ Container enlace_pro-container            Created    |
|                                                          |
└──────────────────────────────────────────────────────────┘
```

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>



##  1. Acceso y Salida (Login & Logout)

El sistema cuenta con un portal de acceso seguro y una salida controlada para proteger los datos de los alumnos.

### Inicio de Sesión (Login)
La interfaz permite elegir roles y validar credenciales con JWT.
> **RUTA:** localhost:8082/web/enlacePro/login

> ![Login de la Aplicación](/img/manualUsuario/logIn.png)

### Cierre de Sesión (Logout)
Ubicado en la parte inferior de la barra lateral para finalizar la sesión de forma segura.

> ![Cierre de Sesión](/img/manualUsuario/logOut.png)

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  2. Planificación y Calendario

EnlacePro incluye un sistema de gestión de tiempos para organizar actividades.

### Vistas de Agenda
Permite visualizar eventos próximos tanto en formato vista semanal como en una perspectiva completa de mes.

> **RUTA:** localhost:8082/web/enlacePro/admin/calendario

> ![Vista Calendario](/img/manualUsuario/calendario.png)
> ![Calendario Vista Mes](/img/manualUsuario/vistaMes.png)

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


##  3. Panel de Control (Dashboard)

El centro de mando con métricas en tiempo real sobre el estado del aula.

> **RUTA:** localhost:8082/web/enlacePro/admin


> ![Dashboard Modo Claro](/img/manualUsuario/escritorio.png)

### Vista en Modo Oscuro
Optimización visual para entornos de baja luminosidad y reducción de fatiga visual.

> ![Dashboard Modo Oscuro](/img/manualUsuario/modoOscuro.png)

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 4. Gestión de Alumnado e Idiomas

Sección dedicada a la gestión del alumnado matriculado en el Aula de Enlace. Aquí se mostrarán los datos personales del alumnado asi como su lengua materna.

### Listados y Formularios
Tablas detalladas para visualizar datos personales y educativos del alumnado. Incluyendo también una opción para descargar en formato pdf un documento con el listado y sus datos.

> **RUTA:** localhost:8082/web/enlacePro/admin/alumnos


> ![Tabla de Alumnos](/img/manualUsuario/listarAlumno.png)


### Flujos de Matriculación, Edición, Borrado y Confirmación
El sistema utiliza un componente unificado para las acciones de modificación y eliminación. Al realizar cambios o borrar un registro (sea alumno o idioma), aparecerá un aviso de confirmación seguido de un mensaje de éxito.

> **RUTA:** localhost:8082/web/enlacePro/admin/alumnos/nuevo


> ![Formulario de Registro](/img/manualUsuario/formularioAlumno.png)
> ![Confirmación de Acción y Mensaje de Éxito](/img/manualUsuario/alumnoMatriculado.png)

 **Pop up al editar alumno o idioma**
> ![Confirmación de Acción y Mensaje de Éxito](/img/manualUsuario/editarAlumno.png)

 **Pop up al eliminar alumno o idioma**
> ![Confirmación de Acción y Mensaje de Éxito](/img/manualUsuario/eliminarAlumno.png)

 **Mensaje de éxito al editar alumno o idioma**
> ![Confirmación de Acción y Mensaje de Éxito](/img/manualUsuario/alumnoActualizado.png)

 **Mensaje de éxito al eliminar alumno o idioma**
> ![Confirmación de Acción y Mensaje de Éxito](/img/manualUsuario/alumnoEliminado.png)


<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 5. Personalización y Accesibilidad (i18n)

Ejemplo de cómo cambia toda la interfaz al alternar idiomas y temas en tiempo real desde la barra superior.

> ![Traducción General](/img/manualUsuario/traduccionIngles.png)

**Traducción modo oscuro**
> ![Traducción General Modo Oscuro](/img/manualUsuario/modoOscuroIngles.png)

---

  <br>
  <img src="https://img.shields.io/badge/Soporte-Aula_de_Enlace-green?style=flat-square" />
  <img src="https://img.shields.io/badge/Desarrollado_para-Gestión_Eficiente-blue?style=flat-square" />