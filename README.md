# Tasca-S4.02-Api-Rest-amb-Spring-boot-Nivel-2

# API REST de Gestión de Frutas

## 📄 Descripción - Ejercicio

Este proyecto implementa una API REST para la gestión de frutas utilizando Spring Boot. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una base de datos de frutas, incluyendo la gestión de nombres y cantidades en kilos.

### Endpoints Disponibles:
- `POST /fruit/add`: Añadir una nueva fruta
- `PUT /fruit/update`: Actualizar una fruta existente
- `DELETE /fruit/delete/{id}`: Eliminar una fruta por ID
- `GET /fruit/getOne/{id}`: Obtener una fruta específica por ID
- `GET /fruit/getAll`: Obtener todas las frutas

## 💻 Tecnologías Utilizadas

- Java 21
- Spring Boot 3.4.7
- Spring Data JPA
- MySQL 8.0
- Maven
- Lombok
- Jakarta Validation
- Spring Web

## 📋 Requisitos

- JDK 21 o superior
- MySQL 8.0 o superior
- Maven 3.6 o superior
- IDE compatible con Spring Boot (recomendado: Eclipse, IntelliJ IDEA)
- Postman o similar para pruebas de API

## 🛠️ Instalación

1. Clonar el repositorio:
```bash
git clone https://github.com/MaraMarchello/Tasca-S4.02-Api-Rest-amb-Spring-boot-Nivel-2
```

2. Configurar la base de datos MySQL:
```sql
CREATE DATABASE fruits_db;
```

3. Configurar el archivo `application.properties` con las credenciales de tu base de datos:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fruits_db?createDatabaseIfNotExist=true
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

4. Compilar el proyecto:
```bash
mvn clean install
```

## ▶️ Implementación

1. Iniciar el servidor MySQL

2. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

3. La API estará disponible en: `http://localhost:8080`

### Ejemplos de Uso:

1. Crear una nueva fruta:
```http
POST http://localhost:8080/fruit/add
Content-Type: application/json

{
    "name": "Manzana",
    "quantityKilos": 10.5
}
```

2. Actualizar una fruta:
```http
PUT http://localhost:8080/fruit/update
Content-Type: application/json

{
    "id": 1,
    "name": "Manzana Verde",
    "quantityKilos": 15.0
}
```

## 🌐 Despliegue

1. Generar el archivo JAR:
```bash
mvn package
```

2. Ejecutar en producción:
```bash
java -jar target/S04T02N02-0.0.1-SNAPSHOT.jar
```

### Configuración para Producción:

1. Crear un archivo `application-prod.properties`:
```properties
spring.datasource.url=jdbc:mysql://[servidor_produccion]:3306/fruits_db
spring.datasource.username=[usuario_produccion]
spring.datasource.password=[contraseña_produccion]
```

2. Ejecutar con perfil de producción:
```bash
java -jar -Dspring.profiles.active=prod target/S04T02N02-0.0.1-SNAPSHOT.jar
```

## 🤝 Contribución

1. Fork del repositorio
2. Crear una rama para tu feature:
```bash
git checkout -b feature/NuevaCaracteristica
```
3. Commit de tus cambios:
```bash
git commit -m 'Añadir nueva característica'
```
4. Push a la rama:
```bash
git push origin feature/NuevaCaracteristica
```
5. Crear un Pull Request

### Guías de Contribución:

- Seguir el estilo de código existente
- Documentar nuevos endpoints o cambios significativos
- Añadir tests para nuevas funcionalidades
- Actualizar el README.md si es necesario

## 📝 Notas Adicionales

- La API utiliza validación de datos para asegurar la integridad de la información
- Implementa manejo global de excepciones para respuestas de error consistentes
- Utiliza Lombok para reducir el código boilerplate
- Sigue las mejores prácticas de REST API 
