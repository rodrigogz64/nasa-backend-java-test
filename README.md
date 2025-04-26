# Proyecto NASA API - Documentación
## Descripción del Proyecto
Este proyecto es una aplicación Spring Boot que consume la API de NASA para buscar imágenes relacionadas con "Apollo 11". La aplicación almacena los datos en una base de datos H2 y proporciona un endpoint REST para consultar los datos almacenados.

## Estructura del Proyecto
```plaintext
nasa-backend-java-test/
├── .mvn/
│   └── wrapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── nasa/
│   │   │           └── prueba/
│   │   │               └── aspirante/
│   │   │                   ├── aplicacion/
│   │   │                   │   └── taskscheduler/
│   │   │                   │       └── PruebaTask.java
│   │   │                   ├── config/
│   │   │                   │   └── AppConfig.java
│   │   │                   ├── dominio/
│   │   │                   │   ├── dto/
│   │   │                   │   │   └── PruebaDto.java
│   │   │                   │   └── entities/
│   │   │                   │       └── PruebaEntity.java
│   │   │                   ├── infraestructura/
│   │   │                   │   ├── clientrest/
│   │   │                   │   │   └── PruebaClienteRest.java
│   │   │                   │   ├── repository/
│   │   │                   │   │   └── PruebaInterfaz.java
│   │   │                   │   └── restcontroller/
│   │   │                   │       ├── PruebaRestController.java
│   │   │                   │       └── EstadisticasController.java
│   │   │                   └── NasaApoloApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── nasa/
│                   └── prueba/
│                       └── aspirante/
│                           └── NasaApoloApplicationTests.java
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
 ```

## Componentes Principales
### 1. Entidades y DTOs
- PruebaEntity.java : Entidad JPA que representa los datos almacenados en la base de datos.
- PruebaDto.java : Objeto de transferencia de datos que mapea la respuesta de la API de NASA.
### 2. Infraestructura
- PruebaClienteRest.java : Cliente REST que consume la API de NASA.
- PruebaInterfaz.java : Repositorio JPA para operaciones CRUD con la base de datos.
- PruebaRestController.java : Controlador REST que expone los endpoints de la API.
### 3. Aplicación
- PruebaTask.java : Tarea programada que se ejecuta cada minuto para obtener y guardar datos de la API de NASA.
### 4. Configuración
- AppConfig.java : Configuración de la aplicación Spring Boot.
- application.properties : Archivo de propiedades para configurar la aplicación.
## Tecnologías Utilizadas
- Spring Boot : Framework para crear aplicaciones Java.
- Spring Data JPA : Para la persistencia de datos.
- H2 Database : Base de datos en memoria para desarrollo.
- RestTemplate : Para consumir APIs REST externas.
- Maven : Herramienta de gestión de dependencias.
## Funcionalidades
1. Consumo Automático de API : La aplicación consume automáticamente la API de NASA cada minuto.
2. Almacenamiento en Base de Datos : Los datos obtenidos se almacenan en una base de datos H2.
3. API REST : Proporciona un endpoint para consultar los datos almacenados.

## Cómo Ejecutar
1. Asegúrate de tener Java 11 instalado.
2. Clona este repositorio.
3. Ejecuta la aplicación con Maven:
   ```bash
   ./mvnw spring-boot:run
    ```
4. Accede a la API en: http://localhost:8080/api/nasa
5. Accede a la consola H2 en: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:nasa_db, Usuario: posgres, Contraseña: 1234)


## Endpoints
- GET /api/nasa : Obtiene los datos almacenados en la base de datos.
- GET /api/nasa/paginado?page=0&size={limit} : Obtiene los datos almacenados en la base de datos paginados.
- GET /api/nasa/center/{center}
- GET /api/nasa/title?title={title}
- GET /api/nasa/nasaid/{nasaId}
- GET /api/nasa/id/{id}
- GET /api/nasa/estadisticas : Obtiene las estadísticas de la API de NASA.

## Arquitectura
Este proyecto sigue una arquitectura hexagonal (puertos y adaptadores) que separa claramente las capas de:

- Dominio : Entidades y lógica de negocio
- Aplicación : Casos de uso y servicios
- Infraestructura : Implementaciones técnicas (REST, base de datos)
Esta arquitectura permite un alto grado de desacoplamiento y facilita las pruebas unitarias.

## Resultados
La aplicación muestra los datos de la API de NASA relacionados con "Apollo 11", incluyendo imágenes, videos y otros recursos multimedia, ordenados por ID de forma descendente.