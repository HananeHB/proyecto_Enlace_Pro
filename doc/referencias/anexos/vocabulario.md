| Endpoint  | Petición HTTP | Body  | Response Code| Response Body  | Posibles Errores|
|---------|---------------|---|--------------------|-------------|----|
| /vocabulario| GET | N/A | 200 (OK) | `[ { "id_vocabulario": 1, "vocabulario": "Manzana", "id_imagen": 5}, { "id_vocabulario": 2, "vocabulario": "Perro", "id_imagen": 12} ]` | VocabularioNotFoundException|
| /vocabulario | POST| `{ "vocabulario": "Gato", "id_imagen": 15 }`| 201 (Created) | `{ "id_vocabulario": 3, "vocabulario": "Gato", "id_imagen": 15 }`| 400 (Solicitud incorrecta)|
| /vocabulario/{id_vocabulario}| GET | N/A | 200 (OK) | `{ "id_vocabulario": 1, "vocabulario": "Manzana", "id_imagen": 5 }` | 404 (No encontrado)|
| /vocabulario/{id_vocabulario}| PUT | `{ "vocabulario": "Naranja", "id_imagen": 6 }` | 200 (OK) | `{ "id_vocabulario": 1, "vocabulario": "Naranja", "id_imagen": 6 }` | 400 (Solicitud incorrecta), 404 (No encontrado) |
| /vocabulario/{id_vocabulario}| DELETE| N/A | 204 (No Content)| N/A| 404 (No encontrado)|
