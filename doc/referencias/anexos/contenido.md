| Endpoint | Petición HTTP | Body | Response Code | Response Body | Posibles Errores |
|---|---|---|---|---|---|
| /contenidos | GET | N/A | 200 (OK) | **{"contenidos":{"id_contenido":1,"id_texto":1,"id_vocabulario":1},{"id_contenido":2,"id_texto":2,"id_vocabulario":2}}** | ContenidoNotFoundException |
| /contenidos | POST | **{"id_texto":3,"id_vocabulario":3}** | 201 (Created) | **{"id_contenido":3,"id_texto":3,"id_vocabulario":3}** | 400 (Solicitud incorrecta)|
| /contenidos/{id_contenido} | GET | N/A | 200 (OK) | **{"id_contenido":1,"id_texto":1,"id_vocabulario":1}** | 404 (No encontrado) |
| /contenidos/{id_contenido} | PUT | **{"id_texto":2,"id_vocabulario":1}** | 200 (OK) | **{"id_contenido":1,"id_texto":2,"id_vocabulario":1}** | 400 (Solicitud incorrecta), 404 (No encontrado) |
| /contenidos/{id_contenido} | DELETE | N/A | 204 (No Content) | N/A | 404 (No encontrado) |
