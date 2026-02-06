# Manual de Usuario: Prototipo Web 

Este manual detalla el uso de la interfaz web para, en este caso, la gestión de alumnos. El sistema simula las **cuatro operaciones fundamentales de gestión de datos (CRUD)**: Create, Read, Update y Delete.

## 1. Acceso 

- **Acceso:** Para utilizar este prototipo, en primer lugar, debes autentificarte según tu rol. .

- **Roles:** Este prototipo simula la vista del **Director**, con acceso total a las operaciones de gestión.

![[prototipo atenticación.png]](img/prototipo%20atenticación.png)
## 2. Visión General de la Aplicación 

Una vez identificado como tal, tu siguiente vista será:

![[prototipo vista director.png]](img/prototipo%20vista%20director.png)

Permitiéndote la gestión tanto de alumnos y profesores como de idiomas.
## 2. Visión General de la Aplicación 

Supongamos que tu tarea actual es gestionar alumnos. La aplicación organiza la funcionalidad de gestión en **cuatro pestañas principales**, visibles en la parte superior del panel:

- **Listar Alumnos (`READ`):** Muestra el registro completo de alumnos.

- **Añadir Nuevo Alumno (`CREATE`/`POST`):** Permite ingresar nuevos alumnos al sistema.

- **Editar Alumno (`UPDATE`/`PUT`):** Modifica los datos de un alumno existente.

- **Eliminar Alumno (`DELETE`):** Borra permanentemente un registro.

![[vista general 1.png]](img/vista%20general.png)

## 3. Pestaña 1: Listar Alumnos (`READ`) 

### Objetivo

Consultar el estado actual y los detalles de todos los alumnos registrados en el sistema.

### Uso

1. Al hacer clic en esta pestaña, o al cargar la página por primera vez, la aplicación inicia el proceso de **Listar Alumnos**.

2. La tabla se te mostrará con la siguiente información clave para cada alumno:

| **Columna**            | **Descripción**                                                | **Importancia**                   |
| ---------------------- | -------------------------------------------------------------- | --------------------------------- |
| **ID**                 | Identificador único del alumno.                                | Necesario para Editar y Eliminar. |
| **Nombre y Apellidos** | Información personal del alumno.                               |                                   |
| **Email y Teléfono**   | Datos de contacto.                                             |                                   |
| **ID Idioma Nativo**   | Número de referencia del idioma maternoo (ej: `1` para Chino). |                                   |

![[get (1).png]](img/get%20(1).png)


## 4. Pestaña 2: Añadir Nuevo Alumno (`CREATE`) 

### Objetivo

Registrar un nuevo alumno en la base de datos simulada.

### Uso

1. Navega a la pestaña **Añadir Nuevo Alumno**.

2. Rellena el formulario completo con los datos del nuevo estudiante:
    
    - **Nombre y Apellidos**
    
    - **Email** (Debe ser un formato de correo válido).
    
    - **Numero de Telefono**
    
    - **ID Idioma Nativo** (Solo acepta valores numéricos).
    
![[post.png]](img/post.png)


2. Al finalizar, recibirás un **mensaje de confirmación** indicando el éxito de la operación y el **nuevo ID asignado** al alumno.

![[mensaje post.png]](img/mensaje%20post.png)

## 5. Pestaña 3: Editar Alumno (`UPDATE`) 

### Objetivo

Modificar o actualizar todos los datos de un alumno existente.

### Uso

1. Navega a la pestaña **Editar Alumno**.

2. Introduce el **ID del Alumno** que deseas modificar en el primer campo. Es improtante que este ID sea correcto.

3. Rellena **TODOS** los demás campos (Nombre, Apellidos, Email, Teléfono, ID Idioma Nativo) con la nueva información o reintroduce la información que no deseas cambiar.

4. Haz clic en **Actualizar Alumno**.

5. Recibirás un **mensaje de confirmación** si el ID fue encontrado y actualizado con éxito. Si el ID no existe, se mostrará un mensaje de error (**Alumno no encontrado**).


![[actualizar.png]](img/actualizar.png)


> **Nota Importante:** Este aplicación procesa una operación `de actualización` completa. Siempre debes enviar **todos los campos** del expediente, incluso si solo deseas cambiar uno.

## 6. Pestaña 4: Eliminar Alumno (`DELETE`) 

### Objetivo

Dar de baja permanentemente un alumno del sistema.

### Uso

1. Navega a la pestaña **Eliminar Alumno**.

2. Introduce el **ID del Alumno** a Eliminar.

3. Haz clic en el botón rojo **Borrar Alumno**.


![[borrar.png]](img/borrar.png)


> **Advertencia:**  **¡La eliminación es inmediata y permanente!**

4. Recibirás un **mensaje de confirmación** de borrado exitoso. Si el ID no existe, se mostrará un error (**Alumno no encontrado**).

![[mensaje borrar.png]](img/mensaje%20borrar.png)

