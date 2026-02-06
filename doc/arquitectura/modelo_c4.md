# Diagrama de Arquitectura - El modelo C4

## Nivel 1: Diagrama de contexto del sistema

El digrama de contexto trata a **EnlacePro** como una "caja negra" y se enfoca en las interacciones externas: las personas y los otros sistemas con los que se comunica.

### Solución- Diagrama de contexto

| Elemento | Tipo | Descripción | Interacción con el Sistema |
|---|----|----|----|
| Administrador  | Persona | "Gestiona (crear, modificar, eliminar y listar usuarios e idiomas)." | Lee y escribe(Gestiona)|
|Usuario| Persona| lee, busca y gestiona contenidos  y niveles" | Lee (Consulta)|
|Sistema de Gestión de Alumnos e Idiomas | Sistema de Interés | La aplicación central que maneja la lógica de negocio| Centro del Diagrama|
|Base de Datos H2| Sistema Externo | El sistema de gestión de bases de datos donde  se almacena toda la información| Solo Lectura/Escritura del Sistema|

### Representación visual
> Nota: En caso de que la imagen no cargue, se puede visualizar el diseño en plantuml [aquí](/design/modelo_c4/diagrama_contexto.puml)
> 
<img src="/img/doc/modelo_c4/diagrama_de_contexto.png" alt="imagen del diagrama de contexto en plantuml" style="max_width=80%; height: auto" >

## Nivel 2: Diagrama de contenedores

Este nivel detalla la distribución técnica de la solución. En este caso, el sistema separa la interfaz de usuario de la lógica de negocio, ejecutando el backend en un entorno de contenedores aislado. 

### Explicación Contenedores: 
- **Aplicación Web (Cliente)**: ejecutada de forma externa. Desarrollada con **Sprring Boot y Thymeleaf**, gestiona la interfaz de usuario y la navegación mediante el nnavegador. 
- **Servicios REST (Servidor- Conteendor)**: ejecutado dentro de un contenedor. Desarrollado con **Spring Boot**.
- **Base de Datos (H2)**: sistema de persistencia relacional(en memoria) que almacena usuarios, contenidos y niveles.
  
### Flujo: 
1. El **Administrador** y el **Usuario** interactúan con la **Aplicación Web** externa a través de su navegador.
2. La **Aplicación Web** actúa como cliente principal. Recibe la solicitud del usuario, prepara la petición necesaria y solicita los datos a los **Servicios REST**.
3. El servicio correspondiente de Alumnos, servicio REST, contiene la lógica de negocio y accede a la base de datos H2. 

### Representación visual 

> Nota: En caso de que la imagen no cargue, se puede visualizar el diseño en plantuml [aquí](/design/modelo_c4/diagrama_contenedores.puml)
> 
<img src="/img/doc/modelo_c4/diagrama_de_contenedores.png" alt="imagen del diagrama de contenedores en plantuml" style="max_width=80%; height: auto" >