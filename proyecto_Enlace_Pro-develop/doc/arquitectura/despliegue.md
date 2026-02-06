# Enlace Pro: Cómo funciona su arquitectura

La aplicación **Enlace Pro** está diseñada con una estructura simple pero efectiva que permite que los usuarios interactúen con ella de manera rápida y eficiente. Esta arquitectura tiene tres partes principales: **Usuario (Cliente), Servidor de Aplicación (Backend) y Base de Datos**. A continuación se explica cómo se conectan y funcionan entre sí.


## 1. Desde el usuario hasta el servidor

Todo comienza cuando un usuario abre Enlace Pro por ejemplo, desde su navegador. Cuando realiza una request, se envía una **solicitud al servidor** usando el puerto 8080. 
## 2. Qué ocurre dentro del servidor

Una vez que la solicitud llega al servidor:

1. **Sistema operativo:** Se encarga de gestionar los recursos de la máquina, como la memoria y el procesador.
2. **Java Virtual Machine (JVM):** Aquí es donde se ejecuta la aplicación Java. La JVM traduce las instrucciones de Enlace Pro para que la computadora pueda ejecutarlas.
3. **Spring Boot:** Este es el corazón de la aplicación. Spring Boot procesa la solicitud del usuario y decide qué hacer con ella. Por ejemplo, si el usuario quiere guardar un registro, Spring Boot se encarga de manejar esa operación.

Si la acción requiere acceder a los datos, Spring Boot se conecta a la **base de datos H2** a través del  JDBC, que actúa como un puente entre la aplicación y la base de datos.


## 3. La base de datos

La base de datos H2 es **temporal y reside en la memoria del servidor**, lo que significa que es muy rápida. Sin embargo, los datos se borran si el servidor se reinicia. H2 recibe las solicitudes de lectura o escritura y ejecuta la operación correspondiente de inmediato.
