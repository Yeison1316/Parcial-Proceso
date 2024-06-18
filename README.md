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
    Instalar la extension o plugin de lombok

## Configuración

1. En el archivo `.properties` en la raíz del proyecto, configura las variables de entorno necesarias:

    ```properties
    server.port = 8081
    spring.datasource.url=jdbc:mysql://localhost:3306/nombreBasededatos
    spring.datasource.password=*****
    spring.datasource.username=root
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    ```

2. Crea la base de datos en tu administrador de base de datos de tu preferencia:

3. Inicia el servicio
   Configurar la variable global en postman http://localhost:8081/
## Uso

### Autenticación

La API utiliza autenticación basada en tokens JWT. Para acceder a la mayoría de los endpoints, es necesario incluir un token de autorización en el encabezado de la solicitud.

- **Registro de usuario**: `/api/register`
- **Inicio de sesión**: `/api/login`

El token recibido tras el inicio de sesión debe incluirse en el encabezado de las solicitudes como:

### Authorization: Bearer <token>
## Registro de Usuario
Método: POST
Endpoint: auth/register
##Descripción: Registra un nuevo usuario.
Datos del cuerpo:
```json
{
  "fullName": "Yeison Mestra",
  "birthDay": "1990-01-01",
  "document": "12345678",
  "phoneNumber": "1234567890",
  "email": "yeison@example.com",
  "password": "pas123",
  "role": "ADMIN"
}
```
Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "User register"
    ],
    "statusCode": "INTERNAL_SERVER_ERROR",
}
```
##Inicio de Sesión
Método: POST
Endpoint: auth/login
Descripción: Autentica un usuario y devuelve un token JWT.
Datos del cuerpo:
```json
{
"email": "email@example.com",
"password": "contraseña"
}
```
Respuesta:
```json
{
"token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```
### Endpoints de Categorías
## Obtener Categorías
Método: GET
Endpoint: category/all
Descripción: Devuelve una lista de todas las categorías.
Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Successful category query"
    ],
    "statusCode": "200",
    "category": [
        {
            "id": 1,
            "nameCategory": "Zapatos"
        },
        {
            "id": 2,
            "nameCategory": "Ropa"
        }
    ]
}
```
##Crear Categoría
Método: POST
Endpoint: category/create
Descripción: Crea una nueva categoría.
Datos del cuerpo:
```json
{
  "nameCategory": "nombre_categoria"
}
```
Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Category create!"
    ],
    "statusCode": "200",
    "category": [
        {
            "id": 3,
            "nameCategory": "Buzos"
        }
    ]
}
```
##Actualizar Categoría
Método: PUT
Endpoint: category/{id}
Descripción: Actualiza una categoría existente.
Datos del cuerpo:
```json
{
"nameCategory": "nuevo_nombre",
}
´´´
Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Update Caegory!"
    ],
    "statusCode": "200",
    "category": [
        {
            "id": 3,
            "nameCategory": "Camisas"
        }
    ]
}
```
Eliminar Categoría
Método: DELETE
Endpoint: /api/categories/{id}
Descripción: Elimina una categoría.
Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Category successful removal"
    ],
    "statusCode": "200",
    "category": [
        {
            "id": 3,
            "nameCategory": "Camisas"
        }
    ]
}
```
### Endpoints de Artículos
Obtener Artículos
Método: GET
Endpoint: article/all
Descripción: Devuelve una lista de todos los artículos.
Respuesta:
```json
{
    "date": "2024-06-18",
    "message": [
        "Successful article query"
    ],
    "statusCode": "200",
    "article": [
        {
            "id": 2,
            "name": "Zapato",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": "Zapatos"
            }
        },
        {
            "id": 3,
            "name": "Tacon",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": "Zapatos"
            }
        },
        {
            "id": 4,
            "name": "carro",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": "Zapatos"
            }
        },
        {
            "id": 5,
            "name": "Buzote",
            "description": "Sudadera cómoda y abrigada con capucha y bolsillo canguro",
            "stock": 50,
            "price": "39.99",
            "dateOfAdmission": "2024-04-08",
            "category": {
                "id": 1,
                "nameCategory": "Zapatos"
            }
        }
    ]
}
```
Crear Artículo
Método: POST
Endpoint: /api/articles
Descripción: Crea un nuevo artículo.
Datos del cuerpo:
json
Copiar código
{
"title": "nombre_artículo",
"description": "descripción del artículo",
"price": 29.99,
"category_id": 1
}
Respuesta:
json
Copiar código
{
"id": 3,
"title": "nombre_artículo",
"description": "descripción del artículo",
"price": 29.99,
"category_id": 1
}
Actualizar Artículo
Método: PUT
Endpoint: /api/articles/{id}
Descripción: Actualiza un artículo existente.
Datos del cuerpo:
json
Copiar código
{
"title": "nuevo_nombre",
"description": "nueva_descripción",
"price": 39.99,
"category_id": 2
}
Respuesta:
json
Copiar código
{
"id": 3,
"title": "nuevo_nombre",
"description": "nueva_descripción",
"price": 39.99,
"category_id": 2
}
Eliminar Artículo
Método: DELETE
Endpoint: /api/articles/{id}
Descripción: Elimina un artículo.
Respuesta:
json
Copiar código
{
"message": "Artículo eliminado exitosamente."
}
Ejemplos de Solicitudes
Crear Usuario
http
Copiar código
POST /api/register
Content-Type: application/json

{
"username": "usuario",
"email": "usuario@example.com",
"password": "contraseña"
}
Iniciar Sesión
http
Copiar código
POST /api/login
Content-Type: application/json

{
"email": "usuario@example.com",
"password": "contraseña"
}
Obtener Categorías
http
Copiar código
GET /api/categories
Authorization: Bearer <token>
Crear Artículo
http
Copiar código
POST /api/articles
Authorization: Bearer <token>
Content-Type: application/json

{
"title": "Nuevo Artículo",
"description": "Descripción del artículo",
"price": 19.99,
"category_id": 1
}
