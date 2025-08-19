# 🚀 Foro Challenge API - Backend

Una aplicación Spring Boot que implementa un sistema CRUD completo para gestión de tópicos en un foro tecnológico, siguiendo principios SOLID y buenas prácticas de desarrollo.

## 🌟 Características Principales

- **CRUD Completo** para tópicos del foro
- **Validación de datos** (evita duplicados en título+mensaje)
- **Autenticación JWT** (protegida por roles)
- **API RESTful** documentada
- **Persistencia** con Hibernate/JPA

## 🛠️ Tecnologías Utilizadas

```bash
- Java 17
- Spring Boot 3
- Spring Security
- Hibernate/JPA
- Lombok
- MySQL/PostgreSQL
- Insomnia (para pruebas API)

🗄️ Estructura de Base de Datos

[https://i.imgur.com/RVQ8LQm.png (Reemplazar con tu diagrama real)
sql](https://imgur.com/a/WhIBcR9)

🔌 Configuración Inicial

    Crear base de datos:
    bash

mysql -u <usuario> -p
> CREATE DATABASE foro_challenge;

Configurar aplicación (application.properties):
properties

spring.datasource.url=jdbc:mysql://localhost:3306/foro_challenge
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

Insertar usuario inicial:
sql

    INSERT INTO perfiles VALUES(1, 'ADMIN');
    INSERT INTO usuarios VALUES(
      1, 
      'Admin', 
      'admin@foro.com', 
      '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 
      1
    );

📡 Endpoints API
Método	Endpoint	Descripción
GET	/topicos	Lista todos los tópicos
GET	/topicos/{id}	Muestra un tópico específico
POST	/topicos	Crea nuevo tópico
PUT	/topicos/{id}	Actualiza tópico existente
DELETE	/topicos/{id}	Elimina tópico (soft-delete)
Ejemplo JSON (POST/PUT):
json

{
  "titulo": "Patrones de Diseño",
  "mensaje": "Discusión sobre Singleton y Factory",
  "curso": "BackEnd",
  "tag": "Java"
}

🏗️ Construcción y Ejecución
bash

# Clonar repositorio
git clone https://github.com/tu-usuario/foro-challenge.git

# Construir proyecto
./mvnw clean package

# Ejecutar
java -jar target/foro-challenge.jar

🧪 Pruebas con Insomnia

    Importar colección de endpoints

    Configurar environment con:

        base_url: http://localhost:8080

    Ejecutar peticiones de ejemplo

📌 Notas Importantes

    Los tópicos requieren título y mensaje únicos

    La eliminación es lógica (status = false)

    Todos los endpoints (excepto login) requieren autenticación

🤝 Contribuciones: ¡Pull requests son bienvenidos!
🐞 Reporte de bugs: Abre un issue en GitHub

¡Happy Coding! 👨‍💻👩‍💻
