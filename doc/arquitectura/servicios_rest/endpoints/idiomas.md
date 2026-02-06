| Endpoint | Petición HTTP | Body | Response Code | Response Body | Posibles Errores |
|---|---|---|---|---|---|
| /idiomas | GET | N/A | 200 (OK) | **{ "idiomas": {"id_idioma": 1, "nombre": "Chino Mandarín"}, {"id_idioma": 2, "nombre": "Árabe"}, {"id_idioma": 3, "nombre": "Rumano"}}** | IdiomaNotFoundException | 
| /idiomas | POST | **{"nombre": "Japones"}**  | 201 (Created) | **{ "id_idioma": 4, "nombre": "Japones"}** | 400 (Solicitud incorrecta)| 
| /idiomas/{id_idioma} | GET | N/A | 200 (OK) | **{ "id_idioma": 1, "nombre": "Chino Mandarín"}** | 404 (No encontrado)| 