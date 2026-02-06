# Manual de Usuario: Gestión de Alumnos con Postman (API) 🛠️

En este manual explicaremos cómo interactuar con nuestra aplicación utilizando la herramienta **Postman** para enviar solicitudes HTTP. El recurso principal es `/alumnos`.

## 1. Configuración de Postman

### URL Base

Usaremos la siguiente **URL base** para todas las peticiones:

> `http://localhost:8080`

### Estructura del Objeto Alumno

Todas las operaciones que envían datos (`POST` y `PUT`) esperan un cuerpo **JSON** (configurado en Postman como **Body > raw > JSON**) con la siguiente estructura:

|**Campo**|**Tipo**|**Requerido**|**Descripción**|**Ejemplo**|
|---|---|---|---|---|
|`nombre`|`string`|**Sí**|Nombre del alumno.|`"Lian"`|
|`apellidos`|`string`|**Sí**|Apellidos del alumno.|`"Li"`|
|`email`|`string`|**Sí**|Correo electrónico.|`"lian.li@colegio.com"`|
|`numeroTelefono`|`long`|**Sí**|Número de teléfono.|`612345678`|
|`idiomaId`|`IdiomaId`|**Sí**|ID numérico del idioma nativo.|`1`|

### Ejemplo de Body JSON

JSON

```
{
  "nombre": "Lian",
  "apellidos": "Li",
  "email": "lian.li@colegio.com",
  "numeroTelefono": 612345678,
  "idiomaId": 1
}
```



## 2. Operación GET - Listar Alumnos

### Descripción

Este método recupera una lista de todos los alumnos o un alumno específico.




## 2. Operación `GET` - Listar Alumnos 

### Descripción

Este método **recupera una lista de todos los alumnos** o un **alumno específico** utilizando su ID.

|**Solicitud**|**Método**|**URL**|**Body**|
|---|---|---|---|
|**GET All**|`GET`|`/alumnos`|Ninguno|
|**GET by ID**|`GET`|`/alumnos/{id}`|Ninguno|

### Ejemplos de Request:

- **GET ALL:**
    
    ```
    GET http://localhost:8080/alumnos
    ```
    
- **GET by ID:**
    
    ```
    GET http://localhost:8080/alumnos/101
    ```
    

### Respuesta Exitosa (Status `200 OK`)

Devuelve un _array_ de objetos `Alumno`:

JSON

```
[
  { 
    "id": 101, 
    "nombre": "Lian", 
    "apellidos": "Li", 
    "email": "...", 
    "numeroTelefono": "...", 
    "idiomaId": 1 
  },
  { 
    "id": 102, 
    "nombre": "Tarek", 
    "apellidos": "Al-Farsi", 
    "email": "...", 
    "numeroTelefono": "...", 
    "idiomaId": 2 
  }
]
```

---

## 3. Operación `POST` (`CREATE`) - Añadir Nuevo Alumno ✨

### Descripción

Este método **crea un nuevo alumno** en la base de datos. El `id` será asignado automáticamente por el servidor.

|**Solicitud**|**Método**|**URL**|**Body**|
|---|---|---|---|
|**CREATE**|`POST`|`/alumnos`|**JSON** (Objeto Alumno **sin** ID)|

### Ejemplo de Body (JSON):

JSON

```
{
  "nombre": "Hassan",
  "apellidos": "Zayed",
  "email": "hassan.z@colegio.com",
  "numeroTelefono": 600112233,
  "idiomaId": 2
}
```

### Respuesta Exitosa (Status `201 Created`)

Devuelve el objeto `Alumno` completo, **incluyendo el ID asignado**:

JSON

```
{
  "id": 104,
  "nombre": "Hassan",
  "apellidos": "Zayed",
  // ... demás campos
}
```

---

## 4. Operación `PUT` (`UPDATE`) - Editar Alumno ✏️

### Descripción

Este método **actualiza los datos** de un alumno específico, identificado por su **ID en la URL**.

|**Solicitud**|**Método**|**URL**|**Body**|
|---|---|---|---|
|**UPDATE**|`PUT`|`/alumnos/{id}`|**JSON** (Objeto Alumno con **TODOS** los campos)|

### Ejemplo de Request (Actualizar Alumno 103):

```
PUT http://localhost:8080/alumnos/103
```

### Ejemplo de Body (JSON) para actualizar el teléfono:

JSON

```
{
  "nombre": "Elena",
  "apellidos": "Popescu",
  "email": "elena.p@colegio.com",
  "numeroTelefono": 677777777,
  "idiomaId": 3
}
```

### Respuesta Exitosa (Status `200 OK`)

Devuelve el objeto `Alumno` **actualizado**.

---

## 5. Operación `DELETE` - Eliminar Alumno 🗑️

### Descripción

Este método **elimina** un alumno del sistema.

|**Solicitud**|**Método**|**URL**|**Body**|
|---|---|---|---|
|**DELETE**|`DELETE`|`/alumnos/{id}`|No tiene|

### Ejemplo de Request (Eliminar Alumno 101):

```
DELETE http://localhost:8080/alumnos/101
```

### Respuesta Exitosa (Status `204 No Content`)

El sistema generalmente responde con un Status `204 No Content` para indicar que la eliminación fue exitosa, pero **no hay contenido que devolver**.