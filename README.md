# Microservicio de Ficha Clínica (MS-FICHA-CLINICA)

Este microservicio es responsable de la gestión centralizada de la información clínica de los pacientes, implementando el estándar internacional **HL7 FHIR R4** para asegurar la interoperabilidad y portabilidad de los datos de salud.

## Descripción del Proyecto

El sistema permite el registro y consulta de diversos recursos clínicos, tales como encuentros médicos, observaciones de signos vitales, diagnósticos (condiciones), procedimientos y notas evolutivas. Está diseñado bajo una arquitectura de microservicios robusta y escalable.

## Especificaciones Técnicas

### Stack Tecnológico

*   **Lenguaje:** Java 21 LTS
*   **Framework:** Spring Boot 4.0.x (basado en Jakarta EE)
*   **Persistencia:** Spring Data JPA con Hibernate
*   **Base de Datos:** MySQL 8.x
*   **Estándar de Interoperabilidad:** HAPI FHIR R4
*   **Herramientas:** Maven, Lombok, Jakarta Validation


### Arquitectura
El proyecto sigue un patrón de diseño en capas para asegurar la separación de responsabilidades:
*   **Controller:** Capa de exposición de APIs REST.
*   **Service:** Lógica de negocio y orquestación.
*   **Repository:** Capa de acceso a datos y persistencia.
*   **DTO (Data Transfer Objects):** Objetos para el intercambio de información.
*   **Model:** Entidades de base de datos y modelos FHIR.
*   **Mapper:** Transformación de datos entre capas.

## Requisitos del Sistema

*   Java Development Kit (JDK) 21.
*   Apache Maven 3.8 o superior.
*   Motor de base de datos MySQL 8.x.

## Configuración y Despliegue

### Entorno Local
El microservicio opera por defecto en el puerto **8001**.

### Configuración de Base de Datos
Ajuste las credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3307/bd_rednorte
spring.datasource.username=root
spring.datasource.password=
```

### Ejecución con Maven

Para iniciar la aplicación en un entorno de desarrollo utilizando Maven:

```bash
mvn spring-boot:run
```

---

## Despliegue con Docker

El proyecto incluye soporte para Docker y Docker Compose, facilitando el levantamiento tanto del microservicio como de la base de datos de manera automatizada.

### Requisitos
*   Docker Desktop o Engine instalado.
*   Docker Compose instalado.

### Instrucciones de Despliegue
Para construir las imágenes e iniciar los contenedores en modo segundo plano:

```bash
docker compose up --build -d
```

### Servicios
*   **App:** Disponible en `http://localhost:8001`.
*   **MySQL:** Disponible en `localhost:3307`.

### Visualización de Logs
Para monitorear el log de la aplicación:

```bash
docker compose logs -f app
```


## Documentación de API

La documentación detallada de cada módulo se encuentra organizada en archivos individuales para facilitar su consulta y pruebas en herramientas como Postman.

| Módulo | Documentación | Descripción |
| :--- | :--- | :--- |
| **Historia Clínica** | [clinical-history-endpoints.md](docs/clinical-history-endpoints.md) | Consulta consolidada del paciente. |
| **Encuentros** | [encounter-endpoints.md](docs/encounter-endpoints.md) | Gestión de atenciones médicas. |
| **Observaciones** | [observation-endpoints.md](docs/observation-endpoints.md) | Signos vitales y resultados. |
| **Condiciones** | [condition-endpoints.md](docs/condition-endpoints.md) | Diagnósticos y antecedentes. |
| **Procedimientos** | [procedure-endpoints.md](docs/procedure-endpoints.md) | Intervenciones realizadas. |
| **Notas Clínicas** | [clinical-note-endpoints.md](docs/clinical-note-endpoints.md) | Registro de evolución diaria. |

## Estructura de Directorios

```text
├── docs/                        # Documentación técnica de APIs
├── src/main/java/cl/rednorte/
│   ├── controller/             # Controladores REST
│   ├── service/                # Lógica de negocio
│   ├── repository/             # Acceso a datos
│   ├── dto/                    # Objetos de transferencia
│   ├── model/                  # Entidades y mapeos FHIR
│   └── mapper/                 # Transformadores de datos
└── src/main/resources/         # Configuración y recursos
```
