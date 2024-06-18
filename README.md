# API de Tienda

## Descripción

Esta API permite gestionar una tienda en línea con funcionalidades para manejar artículos, categorías y usuarios. Ofrece endpoints para crear, leer, actualizar y eliminar artículos y categorías, así como para gestionar el registro y autenticación de usuarios.

## Tabla de Contenidos

- [Instalación](#instalación)
- [Configuración](#configuración)
- [Uso](#uso)
  - [Autenticación](#autenticación)
  - [Endpoints de Usuarios](#endpoints-de-usuarios)
  - [Endpoints de Categorías](#endpoints-de-categorías)
  - [Endpoints de Artículos](#endpoints-de-artículos)
- [Ejemplos de Solicitudes](#ejemplos-de-solicitudes)
- [Licencia](#licencia)

## Instalación

1. Clona el repositorio:

    ```bash
    git clone https://github.com/usuario/tienda-api.git
    ```

2. Navega al directorio del proyecto:

    ```bash
    cd tienda-api
    ```

3. Instala las dependencias:

    ```bash
    npm install
    # o
    pip install -r requirements.txt
    ```

## Configuración

1. Crea un archivo `.env` en la raíz del proyecto y configura las variables de entorno necesarias:

    ```env
    DATABASE_URL=postgres://usuario:contraseña@localhost:5432/tienda
    SECRET_KEY=tu_secreto
    JWT_EXPIRATION=3600
    ```

2. Ejecuta las migraciones de la base de datos:

    ```bash
    npm run migrate
    # o
    python manage.py migrate
    ```

3. Inicia el servidor:

    ```bash
    npm start
    # o
    python manage.py runserver
    ```

## Uso

### Autenticación

La API utiliza autenticación basada en tokens JWT. Para acceder a la mayoría de los endpoints, es necesario incluir un token de autorización en el encabezado de la solicitud.

- **Registro de usuario**: `/api/register`
- **Inicio de sesión**: `/api/login`

El token recibido tras el inicio de sesión debe incluirse en el encabezado de las solicitudes como:

```http
Authorization: Bearer <token>
