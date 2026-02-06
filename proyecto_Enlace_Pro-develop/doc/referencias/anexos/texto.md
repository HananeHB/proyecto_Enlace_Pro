| Endpoint | Petición HTTP | Body | Response Code | Response Body | Posibles Errores |
|---|---|---|---|---|---|
| /textos | GET | N/A | 200 (OK) | {"textos": {"id_texto":1,"texto":"La manzana es roja"},{"id_texto":2,"texto":"El perro corre rápido"}} | TextoNotFoundException |
| /textos | POST | {"texto":"El gato duerme en la silla"} | 201 (Created) | {"id_texto":3,"texto":"El gato duerme en la silla"} | 400 (Solicitud incorrecta) |
| /textos/{id_texto} | GET | N/A | 200 (OK) | {"id_texto":1,"texto":"La manzana es roja"} | 404 (No encontrado) |
| /textos/{id_texto} | PUT | {"texto":"La naranja es jugosa"} | 200 (OK) | {"id_texto":1,"texto":"La naranja es jugosa"} | 400 (Solicitud incorrecta), 404 (No encontrado) |
| /textos/{id_texto} | DELETE | N/A | 204 (No Content) | N/A | 404 (No encontrado) |
