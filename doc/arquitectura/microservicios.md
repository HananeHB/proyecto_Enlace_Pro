# 🚀 Evolución Arquitectónica: De Monolito a Microservicios

<img src="https://img.shields.io/badge/Arquitectura-Distribuida-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Escalabilidad-Alta-success?style=for-the-badge" />


El proyecto **Enlace Pro** nació originalmente como una aplicación monolítica donde todas las funcionalidades (alumnos, seguridad, interfaz) compartían el mismo código y base de datos. Para mejorar la escalabilidad y el mantenimiento, hemos migrado a una **Arquitectura de Microservicios**.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. ¿Por qué el cambio? (Justificación)

La transición se realizó para resolver tres problemas fundamentales del modelo anterior:
1. **Acoplamiento**: Un error en la gestión de alumnos podía tirar abajo todo el sistema de login.
2. **Escalabilidad**: No podíamos escalar la seguridad de forma independiente a la gestión académica.
3. **Persistencia**: El uso de una base de datos en memoria (H2) impedía la persistencia real de datos en un entorno de producción.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. La Nueva Estructura Distribuida

Hemos dividido la aplicación en tres piezas independientes que se comunican a través de la red:

### A. API Gateway (El Conserje)
Es el único punto de entrada para el usuario (Puerto 8080). 
* Recibe las peticiones y las deriva al servicio correcto.
* Oculta la complejidad interna de la red de Docker al cliente.

### B. Auth-Service (La Seguridad)
Microservicio especializado en la identidad.
* Gestiona usuarios, roles y permisos.
* Se encarga exclusivamente de validar quién es quién y emitir el "pasaporte" (**JWT**).
* Utiliza su propia base de datos: **MariaDB**.

### C. Alumnos-Service (El Negocio)
Microservicio que contiene la lógica principal del Aula de Enlace.
* Gestión de alumnos, idiomas y niveles.
* Generación de reportes PDF.
* Utiliza su propia base de datos: **MySQL 8.0**.



```Plaintext

📂 EnlacePro
 ┣ 📂 auth-service          # 🔐 Microservicio de Seguridad
 ┃ ┣ 📂 src                 # Gestión de usuarios y generación de JWT
 ┃ ┗ 📜 Dockerfile          # Imagen del servicio de Autenticación
 ┃ ┗ 📜 pom                 # Dependencias de Spring Security y JWT
 ┣ 📂 alumnos-service       # 🎓 Microservicio de Alumnos
 ┃ ┣ 📂 src                 # CRUD de alumnos y lógica académica
 ┃ ┗ 📜 Dockerfile          # Imagen del servicio de Alumnos
 ┃ ┗ 📜 pom                 # Dependencias
 ┣ 📂 api-gateway           # 🌐 Punto de entrada único (Puerto 8080)
 ┃ ┣ 📂 src                 # Lógica de enrutamiento y filtros
 ┃ ┗ 📜 Dockerfile          # Imagen del Gateway
 ┃ ┗ 📜 pom                 # Dependencias de Spring Cloud Gateway
 ┣ 📂 common-lib            # 💼 Librerías compartidas
 ┃ ┗ 📜 pom                 # Empaquetado como JAR reutilizable
 ┗ 📜 docker-compose.yml    # 🐳 Orquestador del sistema
 ┗ 📜 pom.xml               # 🛠️ POM Padre (Gestión de módulos Maven)

```

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 3. Comparativa: Antes vs. Después

| Característica | Monolito (V1) | Microservicios (V2) |
| :--- | :--- | :--- |
| **Punto de acceso** | Directo al servicio | A través de API Gateway |
| **Seguridad** | Sesiones básicas | JWT (Stateless) |
| **Base de Datos** | H2 (Memoria / Volátil) | MySQL & MariaDB (Persistente) |
| **Despliegue** | Manual / Local | Contenedores Docker |
| **Acoplamiento** | Alto (Todo junto) | Bajo (Independientes) |



<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 4. Comunicación y Red
Para que este ecosistema funcione, hemos implementado una **Red Virtual de Docker**. Los microservicios no se ven por "localhost", sino por sus nombres de servicio (ej: `http://auth-service:8081`), lo que permite que el sistema sea portátil y fácil de desplegar en cualquier servidor.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 5. Beneficios Obtenidos
* **Aislamiento de fallos**: Si el servicio de Alumnos cae, el sistema de Autenticación sigue funcionando.
* **Persistencia Políglota**: Cada servicio usa la base de datos que mejor le conviene.
* **Independencia Tecnológica**: Podríamos programar un nuevo microservicio en un lenguaje diferente y se integraría sin problemas a través del Gateway.

--- 

<div align="center">
  <table style="border-collapse: collapse; border: none; background-color: #0d1117; border-radius: 10px;">
    <tr>
      <td style="padding: 20px;">
        <div align="center">
          <img src="https://img.shields.io/badge/AUTH--SERVICE-UP-31C653?style=for-the-badge&logo=spring" /><br>
          <code>Port: 8081</code>
        </div>
      </td>
      <td style="padding: 20px;">
        <div align="center">
          <img src="https://img.shields.io/badge/ALUMNOS--SERVICE-UP-31C653?style=for-the-badge&logo=spring" /><br>
          <code>Port: 8083</code>
        </div>
      </td>
      <td style="padding: 20px;">
        <div align="center">
          <img src="https://img.shields.io/badge/GATEWAY-UP-31C653?style=for-the-badge&logo=nginx" /><br>
          <code>Port: 8080</code>
        </div>
      </td>
    </tr>
  </table>
</div>

