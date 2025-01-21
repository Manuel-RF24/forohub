# Foro API - Autenticación con JWT

Este proyecto es una API para un foro donde los usuarios pueden crear, consultar, actualizar y eliminar tópicos. Además, la API utiliza autenticación con **JWT** (JSON Web Token) para asegurar el acceso a las rutas protegidas.

## Descripción

Este proyecto tiene como objetivo implementar una API RESTful que permita la gestión de tópicos, y un sistema de autenticación mediante JWT para garantizar que solo los usuarios autenticados puedan realizar operaciones sensibles.

### Características

- **Autenticación con JWT**: Los usuarios deben autenticar sus credenciales (usuario y contraseña) para obtener un token JWT.
- **Protección de rutas**: Las rutas para crear, editar y eliminar tópicos están protegidas, solo los usuarios con un token válido pueden acceder.
- **CRUD de tópicos**: Los usuarios pueden realizar operaciones CRUD sobre los tópicos del foro.

## Tecnologías utilizadas

- **Spring Boot**: Para la creación de la API.
- **Spring Security**: Para gestionar la seguridad de la API.
- **JWT (JSON Web Token)**: Para la autenticación de los usuarios.
- **H2 Database**: Base de datos en memoria para pruebas.

## Requisitos

- JDK 11 o superior
- Maven para la gestión de dependencias
- Conexión a internet para descargar dependencias

## Instalación

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://https://github.com/Manuel-RF24/forohub

## Uso

- **Autenticación**
Para autenticarte y obtener un token JWT, realiza una solicitud POST a la siguiente URL:

URL: http://localhost:8080/api/auth/login
Método: POST
Cuerpo de la solicitud (JSON):
json
Copiar
Editar
{
  "username": "usuarioEjemplo",
  "password": "contraseñaEjemplo"
}
Respuesta exitosa:

json
Copiar
Editar
{
  "token": "Bearer <tu_token_jwt>"
}

- **Crear un tópico**
Para crear un nuevo tópico, realiza una solicitud POST a la siguiente URL:

URL: http://localhost:8080/api/tópicos
Método: POST
Encabezados:
Authorization: Bearer <tu_token_jwt>
Cuerpo de la solicitud (JSON):
json
Copiar
Editar
{
  "title": "Nuevo Tópico",
  "description": "Descripción del tópico"
}

- **Consultar tópicos**
Para obtener una lista de todos los tópicos, realiza una solicitud GET a la siguiente URL:

URL: http://localhost:8080/api/tópicos
Método: GET
Encabezados:
Authorization: Bearer <tu_token_jwt>
Actualizar un tópico
Para actualizar un tópico existente, realiza una solicitud PUT a la siguiente URL:

URL: http://localhost:8080/api/tópicos/{id}
Método: PUT
Encabezados:
Authorization: Bearer <tu_token_jwt>
Cuerpo de la solicitud (JSON):
json
Copiar
Editar
{
  "title": "Tópico actualizado",
  "description": "Descripción actualizada"
}

- **Eliminar un tópico**
Para eliminar un tópico, realiza una solicitud DELETE a la siguiente URL:

URL: http://localhost:8080/api/tópicos/{id}
Método: DELETE
Encabezados:
Authorization: Bearer <tu_token_jwt>

- **Autor**: Manuel Romo Fajardo.
