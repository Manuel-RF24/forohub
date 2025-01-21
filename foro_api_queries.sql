
-- Crear tabla de usuarios para la autenticación
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Insertar un usuario ejemplo
INSERT INTO usuarios (username, password) VALUES ('usuarioEjemplo', 'contraseñaEjemplo');

-- Crear tabla de tópicos
CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL
);

-- Insertar un tópico de ejemplo
INSERT INTO topicos (title, description, estado, autor, curso) 
VALUES ('Primer Tópico', 'Descripción del primer tópico', 'activo', 'usuarioEjemplo', 'Curso de Java');

-- Crear la tabla para almacenar los tokens JWT (si fuera necesario)
CREATE TABLE tokens_jwt (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    token VARCHAR(512) NOT NULL,
    username VARCHAR(255) NOT NULL,
    expiration_date TIMESTAMP NOT NULL
);

-- Insertar un ejemplo de token (solo para referencia)
INSERT INTO tokens_jwt (token, username, expiration_date) 
VALUES ('tokenDeEjemplo', 'usuarioEjemplo', '2025-01-31 23:59:59');
