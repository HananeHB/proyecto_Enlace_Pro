# 🛠️ Documentación de la API: Módulo Contenidos

  <img src="https://img.shields.io/badge/API-REST-blue?style=for-the-badge&logo=postman" />
  <img src="https://img.shields.io/badge/Formato-JSON-orange?style=for-the-badge" />

<br>

Para permitir la comunicación entre el frontend y el backend, Enlace Pro utiliza una arquitectura **REST**. A continuación, se detalla el funcionamiento del endpoint de **Contenidos**, encargado de gestionar la relación entre los textos educativos y el vocabulario asociado.

---

## 1. Especificaciones Técnicas del Endpoint

Esta tabla define cómo el sistema debe solicitar y responder a las peticiones de gestión de contenidos.

| 🧩 Ruta (Endpoint) | 📥 Petición | 📝 Body (Entrada) | 🚥 Código | 📤 Response (Salida) | ⚠️ Errores |
| :--- | :---: | :--- | :---: | :--- | :--- |
| `/contenidos` | **GET** | N/A | `200` | Lista de todos los contenidos | `ContenidoNotFound` |
| `/contenidos` | **POST** | `{"id_texto":3, "id_vocabulario":3}` | `201` | Datos del contenido creado | `400: Bad Request` |
| `/contenidos/{id}` | **GET** | N/A | `200` | Detalle del contenido único | `404: Not Found` |
| `/contenidos/{id}` | **PUT** | `{"id_texto":2, "id_vocabulario":1}` | `200` | Datos actualizados | `400, 404` |
| `/contenidos/{id}` | **DELETE** | N/A | `204` | N/A | `404: Not Found` |

---

## 2. Lógica de Intercambio de Datos

El flujo de información en este módulo se basa en **tres pilares** para asegurar que los datos lleguen correctamente a la interfaz.

### Fase A: Petición y Autenticación
Cada vez que la aplicación necesita mostrar materiales, envía una petición **GET** al servidor. Al utilizar **Spring Security** y **JWT**, el sistema verifica primero si el usuario (profesor o alumno) tiene permisos para ver o modificar esos contenidos antes de procesar la tabla.

---

### Fase B: Procesamiento en el Modelo
Una vez recibida una petición (como un **POST** para crear nuevo material), el servidor valida que los IDs de texto y vocabulario existan. Si todo es correcto, el sistema genera un nuevo objeto de contenido y lo guarda en la base de datos, devolviendo un código `201` de éxito.

---

### Fase C: Respuesta y Visualización
La respuesta viaja en formato **JSON**, el cual es interpretado por el frontend para renderizar las tablas dinámicas que hemos visto en el apartado de Diseño Visual. Si ocurre un error (por ejemplo, intentar borrar un contenido que no existe), el sistema devuelve una excepción controlada para informar al usuario de forma segura.

---

  <br>
  <img src="https://img.shields.io/badge/Protocolo-HTTP/1.1-gray?style=flat-square" />
  <img src="https://img.shields.io/badge/Seguridad-JWT_Verified-black?style=flat-square&logo=jsonwebtokens" />