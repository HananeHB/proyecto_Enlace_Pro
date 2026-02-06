| Endpoint | Petición HTTP | Body | Response Code | Response Body | Posibles Errores |
|---|---|---|---|---|---|
| /informes | GET | N/A | 200 (OK) | **{"informes":{"id_informe":1,"contenido":"Informe de progreso del estudiante"},{"id_informe":2,"contenido":"Informe mensual del curso"}}** | InformeNotFoundException |
| /informes | POST | **{"contenido":"Informe detallado de evaluación"}** | 201 (Created) | **{"id_informe":3,"contenido":"Informe detallado de evaluación"}** | 400 (Solicitud incorrecta) |
| /informes/{id_informe} | GET | N/A | 200 (OK) | **{"id_informe":1,"contenido":"Informe de progreso del estudiante"}** | 404 (No encontrado) |
| /informes/{id_informe} | PUT | **{"contenido":"Informe actualizado de progreso"}** | 200 (OK) | **{"id_informe":1,"contenido":"Informe actualizado de progreso"}** | 400 (Solicitud incorrecta), 404 (No encontrado) |
| /informes/{id_informe} | DELETE | N/A | 204 (No Content) | N/A | 404 (No encontrado) |
