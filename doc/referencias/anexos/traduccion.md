| Endpoint | Petición HTTP | Body | Response Code | Response Body | Posibles Errores |
|---|---|---|---|---|---|
| /traducciones | GET | N/A | 200 (OK) | **{"traducciones":{"id_traduccion":1,"traduccion":"Apple","id_texto":1,"id_vocabulario":1,"id_idioma":2,"id_informe":5},{"id_traduccion":2,"traduccion":"Dog","id_texto":2,"id_vocabulario":2,"id_idioma":2,"id_informe":5}}** | TraduccionNotFoundException |
| /traducciones | POST | **{"traduccion":"Cat","id_texto":3,"id_vocabulario":3,"id_idioma":2,"id_informe":5}** | 201 (Created) | **{"id_traduccion":3,"traduccion":"Cat","id_texto":3,"id_vocabulario":3,"id_idioma":2,"id_informe":5}** | 400 (Solicitud incorrecta)|
| /traducciones/{id_traduccion} | GET | N/A | 200 (OK) | **{"id_traduccion":1,"traduccion":"Apple","id_texto":1,"id_vocabulario":1,"id_idioma":2,"id_informe":5}** | 404 (No encontrado) |
| /traducciones/{id_traduccion} | PUT | **{"traduccion":"Orange","id_texto":1,"id_vocabulario":1,"id_idioma":2,"id_informe":5}** | 200 (OK) | **{"id_traduccion":1,"traduccion":"Orange","id_texto":1,"id_vocabulario":1,"id_idioma":2,"id_informe":5}** | 400 (Solicitud incorrecta), 404 (No encontrado) |
| /traducciones/{id_traduccion} | DELETE | N/A | 204 (No Content) | N/A | 404 (No encontrado) |
