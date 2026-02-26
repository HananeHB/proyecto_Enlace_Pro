# 🧪 Plan de Pruebas

<img src="https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white" />
<img src="https://img.shields.io/badge/Testcontainers-MySQL-2496ED?style=for-the-badge&logo=docker&logoColor=white" />
<img src="https://img.shields.io/badge/Spring_Boot-Testing-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />

En **EnlacePro**, se ha definido una estrategia de pruebas orientada a garantizar la calidad, estabilidad e integración real del microservicio `alumnos-service`.

La estrategia combina distintos niveles de validación para asegurar tanto la lógica de dominio como la persistencia real de datos.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 1. Estrategia General

Se aplican tres niveles principales de pruebas:

| Tipo de prueba | Objetivo | Tecnología utilizada |
|---------------|----------|----------------------|
| Unitarias | Validar la lógica de dominio | JUnit 5 |
| Integración con Mock | Simular repositorios sin base de datos | Implementaciones Mock |
| Integración real | Validar persistencia contra MySQL real | Testcontainers + Spring Boot |

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 2. Pruebas de Persistencia con Testcontainers 🐳

Para validar el comportamiento real de los repositorios JPA, se utiliza **Testcontainers**, una librería que permite levantar contenedores Docker automáticamente durante la ejecución de los tests.


### 🔹 ¿Qué aporta Testcontainers?

- Levanta una instancia real de **MySQL 8**
- Integración automática con Spring Boot mediante `@ServiceConnection`
- Aislamiento total entre ejecuciones
- No requiere base de datos instalada localmente

Durante la ejecución de los tests:

1. Se inicia un contenedor MySQL.
2. Spring Boot establece la conexión automáticamente.
3. Se ejecutan las operaciones CRUD.
4. El contenedor se destruye al finalizar la ejecución.

Esto garantiza que las pruebas se ejecuten en un entorno controlado, reproducible y equivalente al de producción.


<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 3. Pruebas del Repositorio JPA

Se validan las operaciones fundamentales de persistencia:

- ✔ Crear entidad
- ✔ Obtener todos los registros
- ✔ Buscar por ID
- ✔ Buscar por campo específico
- ✔ Actualizar entidad
- ✔ Eliminar registro

### 📌 Entidades cubiertas

- Alumno
- Idioma

Las pruebas verifican:

- Generación automática de identificadores
- Persistencia real en base de datos
- Integridad de los datos almacenados
- Eliminación efectiva de registros

Gracias al uso de `@Transactional`, cada test mantiene consistencia y evita efectos colaterales entre ejecuciones.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 4. Pruebas con Repositorios Mock

Además de las pruebas contra base de datos real, se implementaron repositorios en memoria para:

- Validar lógica de dominio sin dependencia externa
- Acelerar la ejecución de pruebas unitarias
- Garantizar independencia de la infraestructura

Estas pruebas validan:

- Guardado de entidades
- Recuperación por ID
- Eliminación por ID
- Listado completo de registros

Este enfoque respeta el principio de separación entre dominio e infraestructura.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>

## 5. Pruebas de Integración del Controller

Se validan los flujos principales de:

- Creación de recursos
- Recuperación de datos
- Eliminación

En estas pruebas se utilizan implementaciones mock del repositorio, lo que permite validar la capa web sin necesidad de levantar infraestructura externa.

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 6.  Dependencias Utilizadas

Las siguientes dependencias permiten la integración entre Spring Boot y Testcontainers:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-testcontainers</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>1.20.3</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.testcontainers</groupId>
    <artifactId>mysql</artifactId>
    <version>1.20.1</version>
    <scope>test</scope>
</dependency>
```

<p align="start" style="margin-top: 30px; margin-bottom: 30px;"> ◆ ◆ ◆ </p>


## 7.  Evidencias de Ejecución


![Ejecución correcta de los tests](/img/test/cap_testing_alumnos_service.png)


