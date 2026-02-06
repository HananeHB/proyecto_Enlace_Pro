| Endpoint | Petición HTTP | Body | Response Code | Response Body | Posibles Errores |
|---|---|---|---|---|---|
| /imagenes | GET | N/A | 200 (OK) | **{"imagenes":{"id_imagen":1,"imagen":"manzana.png"},{"id_imagen":2,"imagen":"perro.jpg"}}** | ImagenNotFoundException |
| /imagenes | POST | **{"imagen":"gato.webp"}** | 201 (Created) | **{"id_imagen":3,"imagen":"gato.webp"}** | 400 (Solicitud incorrecta)|
| /imagenes/{id_imagen} | GET | N/A | 200 (OK) | **{"id_imagen":1,"imagen":"manzana.png"}** | 404 (No encontrado) |
| /imagenes/{id_imagen} | PUT | **{"imagen":"naranja.jpg"}** | 200 (OK) | **{"id_imagen":1,"imagen":"naranja.jpg"}** | 400 (Solicitud incorrecta), 404 (No encontrado) |
| /imagenes/{id_imagen} | DELETE | N/A | 204 (No Content) | N/A | 404 (No encontrado) |
